package com._520it.wx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wall on 2017/9/5.
 */
@Controller
public class LotteryController {

    @RequestMapping("/lottery")
    public String lottery(HttpServletRequest req,String present){
        System.out.println("奖品: "+present);
        req.setAttribute("username","丁某");
        return "lottery";
    }


}
