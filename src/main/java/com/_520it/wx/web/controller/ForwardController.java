package com._520it.wx.web.controller;

import com._520it.wx.util.HttpUtil;
import com._520it.wx.util.SecurityUtil;
import com._520it.wx.util.WeixinUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by zmh on 2017/9/5.
 */
@Controller
public class ForwardController {
    @RequestMapping(value = "/share")
    public String share(HttpServletRequest request){
        String ticket = WeixinUtil.getTicket();
        String noncestr = "zmh";
        String timestamp = "454545545";
        String url = "http://zhou.nat100.top/share.do";
        String[] arr = {"jsapi_ticket="+ticket,"timestamp="+timestamp,"noncestr="+noncestr,"url="+url};
        Arrays.sort(arr);
        String str = "";
        for(int i = 0; i < arr.length; i ++){
            if(i != arr.length -1){
                str+=arr[i]+"&";
            }else {
                str += arr[i];
            }
        }
        String signature = SecurityUtil.SHA1(str);
        System.out.println(signature);
        request.setAttribute("signature",signature);
        return "share";
    }
}
