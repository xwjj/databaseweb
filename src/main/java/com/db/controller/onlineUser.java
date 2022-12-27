package com.db.controller;

import com.db.pojo.*;
import com.db.service.managerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: 处理线上用户的请求
 * @Author: xw
 * @Date: 2022/12/6 20:43
 */
@Controller
public class onlineUser {
    @Autowired
    managerService control;

    /*用户登录*/
    @PostMapping("/user/Login")
    public String loginUser(String username, String password, Model model) {
        if (control.verifyOnlineUser(username, password)) {
            model.addAttribute("using", username);
            List<foodDisplay1> map = control.selectIpProduct(username);
            model.addAttribute("map", map);
            return "onlineshopping";
        } else
            return "redirect:/user/shopping";
    }

    /*用户注册*/
    @RequestMapping("/user/insert")
    public String insertUser(@RequestBody onlineuser newUser) {
        System.out.println("newUser = " + newUser);
        control.insertOnlineUser(newUser);
        return "userLogin";
    }

    /*控制器返回类型是void 默认返回的路径为请求路径的视图 如果找不到就会报下面的错误
     * org.thymeleaf.exceptions.TemplateInputException: Error resolving template
     * */
    /*用户添加食物添加到购物车*/
    @RequestMapping("/add/food")
    @ResponseBody
    public void addFood(@RequestBody cartUser1 fo) {
        control.insertSubscribe(fo);
    }

    /*显示用户的所购项 购物车*/
    @RequestMapping("/look/carts/{username}")
    public String userCart(@PathVariable String username, Model model) {
        List<completeCart1> subscribes = control.displayCart(username);
        model.addAttribute("subscribes", subscribes);
        model.addAttribute("using", username);
        subscribes.forEach(s -> s.setAll(s.getOutprice() * s.getNumber()));
        return "cart";
    }

    /*删除订单*/
    @RequestMapping("/delete/subscribe")
    @ResponseBody
    public void deleteSubscribe(@RequestBody ByThis1 by) {
        control.deleteS(by.getUsername(), by.getName(), by.getQuality().charAt(0));
    }

    /*返回至用户购物界面*/
    @RequestMapping("/get/back/{username}")
    public String getBack(@PathVariable String username, Model model) {
        model.addAttribute("using", username);
        List<foodDisplay1> map = control.selectIpProduct(username);
        model.addAttribute("map", map);
        return "onlineshopping";
    }

    /*订单减去一份*/
    @RequestMapping("/food/subtract")
    @ResponseBody
    public void subtract(@RequestBody ByThis1 by){
        control.subtractOne(by);
    }

    /*订单增加一份*/
    @RequestMapping("/food/add")
    @ResponseBody
    public void add(@RequestBody ByThis1 by){
        control.addOne(by);
    }

    @PostMapping("/user/search")
    public String searchInfo(String name,String username, Model model, HttpServletRequest request){
        search1 by = new search1();
        by.setName(name);
        by.setUsername(username);
        model.addAttribute("using",username);
        List<foodDisplay1> map=control.searchFood(by.getName(),by.getUsername());
        model.addAttribute("map",map);
        return "onlineshopping";
    }
}

