package com._520it.wx.web.controller;

import com._520it.wx.util.HttpUtil;
import com._520it.wx.util.SecurityUtil;
import com._520it.wx.util.WeixinUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by zmh on 2017/9/3.
 */
@Controller
public class AutoriseController {

    @RequestMapping(value = "/main")
    public String index(String code, HttpServletRequest request){
        String s = HttpUtil.get(WeixinUtil.GET_WEB_ACCESSTOKEN_URL.replace("APPID", WeixinUtil.APPID).replace("SECRET", WeixinUtil.APPSECRET).replace("CODE", code));
        System.out.println(s);
        JSONObject json = JSON.parseObject(s);
        String access_token = (String) json.get("access_token");
        String openid = (String) json.get("openid");
        /*String access_token = HttpUtil.get(WeixinUtil.GET_TICKET_URL.replace("ACCESS_TOKEN", WeixinUtil.getAccessToken()));
        System.out.println(access_token);*/
        request.getSession().setAttribute("openid",openid);
        return "main";
    }
}
