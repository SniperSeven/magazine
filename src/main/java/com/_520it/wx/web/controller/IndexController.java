package com._520it.wx.web.controller;

import com._520it.wx.domain.Client;
import com._520it.wx.domain.Message;
import com._520it.wx.domain.XmlMessageEntity;
import com._520it.wx.service.IClientService;
import com._520it.wx.service.IMessageService;
import com._520it.wx.util.HttpUtil;
import com._520it.wx.util.SecurityUtil;
import com._520it.wx.util.WeixinUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IClientService clientService;

    @Autowired
    private IMessageService messageService;

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
        Client client = clientService.selectByOpenid(entity.getFromUserName());
        if("event".equals(entity.getMsgType())){
           if("subscribe".equals(entity.getEvent())){
               if(client == null){
                   client = new Client();
                   client.setStatus(true);
                   client.setOpenId(entity.getFromUserName());
                   String result = HttpUtil.get(WeixinUtil.GET_USERINFO_URL.replace("ACCESS_TOKEN", WeixinUtil.getAccessToken()).replace("OPENID", entity.getFromUserName()));
                   System.out.println(result);
                   JSONObject json = JSON.parseObject(result);
                   client.setName((String)json.get("nickname"));
                   client.setAddress((String)json.get("province") + (String)json.get("city"));
                   client.setConcernTime(new Date());
                   clientService.insert(client);
               }else {
                   client.setConcernTime(new Date());
                   client.setStatus(true);
                   clientService.updateByPrimaryKey(client);
               }
                newEntity.setContent("Hi,总算见到你啦,小芯已经等您很久啦!这里有最好吃的蛋糕和最可爱的客服姐姐哦");
           }else if("unsubscribe".equals(entity.getEvent())){
               client.setStatus(false);
               client.setCancelConcernTime(new Date());
               clientService.updateByPrimaryKey(client);
           }
        } else {
            String s = HttpUtil.get(WeixinUtil.GET_TULING_URL.replace("INFO",entity.getContent()));
            System.out.println(s);
            JSONObject json = JSON.parseObject(s);
            newEntity.setContent((String) json.get("text"));
            Message message = new Message();
            message.setClient(client);
            message.setInputtime(new Date());
            message.setReceivecontent(entity.getContent());
            message.setReplycontent(newEntity.getContent());
            message.setType(entity.getMsgType());
            messageService.insert(message);
        }
        return newEntity;
    }

}

























