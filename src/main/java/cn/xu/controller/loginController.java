package cn.xu.controller;

import cn.xu.entity.User;
import cn.xu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/check")
    public String login(@RequestParam("username") String username,@RequestParam("upwd") String upwd, Model model)
    {
        User user=userService.queryUserByName(username);
        if(user!=null)
        {
            if(user.getUpwd().equals(upwd))
            {
                model.addAttribute("user",user);
                model.addAttribute("hello","hello");
                return "main.html";
            }
            else
            {
                return "relogin.html";
            }
        }
        else {
            System.out.println("null");
            return "relogin.html";
        }
    }
    @PostMapping("/login")
    public String login()
    {
        return "login.html";
    }

    @RequestMapping("/register")
    public String register()
    {
        return "register.html";
    }

    @RequestMapping("/checkregister")
    public String checkregister(@RequestParam("username") String username,@RequestParam("upwd") String upwd,@RequestParam("reupwd") String reupwd,Model model)
    {
        if(!upwd.equals(reupwd))
        {
            return "passworderror.html";
        }
        else {
            if (isRegisterd(username)) {
                return "exist.html";
            } else {
                User user = new User(username, upwd);
                userService.addUser(user);
                return "login";
            }
        }
    }

    public boolean isRegisterd(String username)
    {
        User user = userService.queryUserByName(username);
        if(user!=null)
        {
            return true;
        }
        else
            return false;
    }
}
