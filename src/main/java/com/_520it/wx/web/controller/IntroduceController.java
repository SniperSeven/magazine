package com._520it.wx.web.controller;

import com._520it.wx.domain.Client;
import com._520it.wx.service.IClientService;
import com._520it.wx.util.HttpUtil;
import com._520it.wx.util.WeixinUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wall on 2017/9/5.
 */
@Controller
public class IntroduceController {

    @RequestMapping("/introduce")
    public String lottery(){
        return "introduce";
    }

}
