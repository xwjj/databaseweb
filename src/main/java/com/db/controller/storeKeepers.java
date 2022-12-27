package com.db.controller;

import com.db.pojo.*;
import com.db.service.managerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description: 处理店家的请求
 * @Author: xw
 * @Date: 2022/12/13 16:54
 */
@Controller
public class storeKeepers {
    @Autowired
    managerService sk;

    /*管理店家登录*/
    @PostMapping("keeper/login")
    public String loginKeeper(String username, String password, Model model) {
        model.addAttribute("using", username);
        List<keeperByThis> stores = sk.Keeper(username, password);
        if (stores != null) {
            stores.forEach(s -> {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM dd,yyyy HH:mm:ss");
                s.setTool(simpleDateFormat.format(s.getStart()));
            });
            model.addAttribute("stores", stores);
            return "storeStock";
        } else
            return "redirect:/keeper/store";
    }

    /*删除这个库存*/
    @PostMapping("/keeper/delete")
    @ResponseBody
    public void deleteThis(@RequestBody ByThis1 by) {
        sk.deleteThis(by);
    }

    /*售出一份*/
    @PostMapping("/keeper/subtractOne")
    @ResponseBody
    public void deleteOne(@RequestBody ByThis1 by) {
        sk.deleteA(by);
    }

    /*增加一份*/
    @PostMapping("/keeper/addOne")
    @ResponseBody
    public void addOne(@RequestBody ByThis1 by) {
        sk.addA(by);
    }

    /*跳转到收银页面*/
    @RequestMapping("/into/cash/{username}")
    public String earn(@PathVariable String username, Model model) {
        model.addAttribute("using", username);
        List<byCash1> desk = sk.intoMoney(username);
        model.addAttribute("desk", desk);
        Double money = sk.sortMoney(username);
        model.addAttribute("cash1", money);
        return "cash";
    }

    /*销售功能*/
    @PostMapping("/sell/food")
    @ResponseBody
    public void sell(@RequestBody sortMoney1 money1) {
        sk.sortCash(money1);
    }

    /*回撤*/
    @RequestMapping("/keeper/back/{username}")
    public String getBack(@PathVariable String username, Model model) {
        model.addAttribute("using", username);
        List<keeperByThis> stores = sk.Keeper(username);
        if (stores != null) {
            stores.forEach(s -> {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM dd,yyyy HH:mm:ss");
                s.setTool(simpleDateFormat.format(s.getStart()));
            });
            model.addAttribute("stores", stores);
            return "storeStock";
        } else
            return "redirect:/keeper/store";
    }

    /*体哦转到修改库存信息界面并传递需要的数据*/
    @RequestMapping("/stock/change/{username}/{name}/{quality}")
    public String changeStock(@PathVariable("username") String username, @PathVariable("name") String name, @PathVariable("quality") String quality, Model model) {
        ByThis1 byThis1 = new ByThis1(username, name, quality);
        model.addAttribute("change", byThis1);
        return "outprice";
    }

    /*修改数据，异步通信*/
    @PostMapping("/keeper/change/sell")
    @ResponseBody
    public void keeperChangeSell(@RequestBody changeByThis1 by) {
        sk.updateStock(by);
    }

    /*跳转到进货界面*/
    @RequestMapping("/into/stock/{username}")
    public String intoFood(@PathVariable("username") String username, Model model) {
        List<allfood> food = sk.allFood();
        model.addAttribute("all", food);
        model.addAttribute("using", username);
        return "into";
    }

    /*进货功能*/
    @PostMapping("/into/food")
    @ResponseBody
    public void intoFood(@RequestBody intoFoodBy1 by) {
        sk.intoStore(by);
    }

    /*商铺注册账户*/
    @PostMapping("/keeper/register")
    @ResponseBody
    public void newKeeper(@RequestBody newKeeper1 by) {
        sk.insertKeeper(by);
    }

    /*查看线上用户订单*/
    @RequestMapping("/keeper/LookSub/{username}/{num}")
    public String lookSub(@PathVariable("username") String username,@PathVariable("num") Integer num, Model model) {
        /*开启分页功能*/
        PageHelper.startPage(num,4);
        /*显示所有商品订单*/
        List<onlineSub1> subscribes = sk.showSub(username);
        PageInfo<onlineSub1> pages = new PageInfo<>(subscribes, 5);
        model.addAttribute("pages", pages);
        model.addAttribute("using", username);
        return "onlineSub";
    }

}
