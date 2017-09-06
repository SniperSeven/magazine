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
public class LotteryController {

    @Autowired
    private IClientService clientService;

    @RequestMapping("/lottery")
    public String lottery(String present,HttpServletRequest request,String code){
        if(present != null){
            //System.out.println("奖品: "+present);
            String openid = (String) request.getSession().getAttribute("openid");
            Client client = clientService.selectByOpenid(openid);
            //----------------------记得设置礼品
            clientService.updateByPrimaryKey(client);
        }else{
            String s = HttpUtil.get(WeixinUtil.GET_WEB_ACCESSTOKEN_URL.replace("APPID", WeixinUtil.APPID).replace("SECRET", WeixinUtil.APPSECRET).replace("CODE", code));
            System.out.println(s);
            JSONObject json = JSON.parseObject(s);
            String access_token = (String) json.get("access_token");
            String openid = (String) json.get("openid");
            request.getSession().setAttribute("openid",openid);
            Client client = clientService.selectByOpenid(openid);
            request.setAttribute("username",client.getName());
        }
        return "lottery";
    }

}
