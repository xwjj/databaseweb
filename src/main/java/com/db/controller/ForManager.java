package com.db.controller;

import com.db.pojo.*;
import com.db.service.managerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 总公司页面跳转
 * @Author: xw
 * @Date: 2022/12/22 20:52
 */
@Controller
public class ForManager {
    @Autowired
    private managerService ms;

    /*管理人员登录*/
    @PostMapping("/man/login")
    public String loginManager(String user, String password, Model model) {
        if (ms.verifyManager(user, password)) {
            List<keeperInfo> keepers = ms.showKeeper();
            List<storeForCom1> stores=ms.showStore();
            List<usersForCom1> users=ms.showUsers();
            model.addAttribute("keepers", keepers);
            model.addAttribute("stores",stores);
            model.addAttribute("users",users);
            return "topCompany";
        } else
            return "redirect:/login/manager";
    }

    /*修改店主信息*/
    @PostMapping("/change/keeper")
    public String changeKeeper(Integer id, String username, String password, String ip, Model model) {
        ms.updateKeeper(id, username, password, ip);
        List<keeperInfo> keepers = ms.showKeeper();
        List<storeForCom1> stores=ms.showStore();
        List<usersForCom1> users=ms.showUsers();
        model.addAttribute("keepers", keepers);
        model.addAttribute("stores",stores);
        model.addAttribute("users",users);
        return "topCompany";
    }

    /*删除店长*/
    @PostMapping("/remove/keeper")
    @ResponseBody
    public void removeKeeper(@RequestBody String id) {
        Matcher matcher = Pattern.compile("\\d+").matcher(id);
        Integer by = null;
        while (matcher.find()){
            by=Integer.parseInt(matcher.group(0));
        }
        if(by==null) return;
        ms.deleteKeeper(by);
    }

    /*修改线上用户信息*/
    @PostMapping("/change/users")
    @ResponseBody
    public void editUsers(@RequestBody onlineuser o){
        ms.updateUU(o);
    }

    /*删除用户信息*/
    @PostMapping("/remove/users")
    @ResponseBody
    public void removeUsers(@RequestBody username1 username){
        ms.deleteUsers(username.getUsername());
    }
}
