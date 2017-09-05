package com._520it.wx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by zmh on 2017/8/24.
 */
@Controller
public class MainController {


    @RequestMapping("/main_view")
    public String main(){
        return "main";
    }
}
