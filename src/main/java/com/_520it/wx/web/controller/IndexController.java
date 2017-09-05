package com._520it.wx.web.controller;

import com._520it.wx.domain.XmlMessageEntity;
import com._520it.wx.util.HttpUtil;
import com._520it.wx.util.SecurityUtil;
import com._520it.wx.util.WeixinUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by zmh on 2017/9/3.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public String index(String signature,String timestamp,String nonce,String echostr){
        System.out.println(signature);
        String[] arr = {WeixinUtil.TOKEN,timestamp,nonce};
        Arrays.sort(arr);
        String str = "";
        for (String s : arr) {
            str+=s;
        }
        if(signature.equals(SecurityUtil.SHA1(str))){
            System.out.println("接入成功");
            return echostr;
        }
        System.out.println("接入失败");
        return null;
    }

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    @ResponseBody
    public XmlMessageEntity index1(@RequestBody XmlMessageEntity entity,String key){
        System.out.println(entity);
        XmlMessageEntity newEntity = new XmlMessageEntity();
        newEntity.setFromUserName(entity.getToUserName());
        newEntity.setToUserName(entity.getFromUserName());
        newEntity.setMsgType("text");
        newEntity.setCreateTime(new Date().getTime());
        if("event".equals(entity.getMsgType()) && "subscribe".equals(entity.getEvent())){
            HttpUtil.get(WeixinUtil.GET_USERINFO_URL.replace("ACCESS_TOKEN", WeixinUtil.getAccessToken()).replace("OPENID", entity.getFromUserName()));
            newEntity.setContent("Hi,总算见到你啦,小芯已经等您很久啦!这里有最好吃的蛋糕和最可爱的客服姐姐哦");
        }else {
            String s = HttpUtil.get(WeixinUtil.GET_TULING_URL.replace("INFO",entity.getContent()));
            System.out.println(s);
            JSONObject json = JSON.parseObject(s);
            newEntity.setContent((String) json.get("text"));
        }
        return newEntity;
    }

}

























