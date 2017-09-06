package com._520it.wx.util;

import com._520it.wx.domain.Material;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class WeixinUtil {

    public static final String TOKEN = "zhoumanhong";
    public static final String APPID = "wx0c5d7a2b65075463";
    public static final String APPSECRET = "55ef0ef50ce1aac9015cf3df9653582a";

    private static String accessToken;
    private static Long expiresTime = 0L;
    private static String ticket;
    private static Long ticketExpiresTime = 0L;

    public static final String GET_USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    public static final String GET_WEB_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    public static final String GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static final String GET_WEB_ACCESSTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code ";

    public static final String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public static final String SEND_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    public static final String GET_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    public static final String GET_TULING_URL = "http://www.tuling123.com/openapi/api?info=INFO&key=0a16adc7f0b7429886038162f881bca3";

    public static final String ADD_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";

    public static final String GET_SUCAI_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";


    public static String getAccessToken(){
        if(new Date().getTime() > expiresTime){
            String s = HttpUtil.get(GET_ACCESSTOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET));
            System.out.println(s);
            JSONObject json = JSON.parseObject(s);
            accessToken = (String)json.get("access_token");
            Integer expires_in = (Integer) json.get("expires_in");
            expiresTime = new Date().getTime() + ((expires_in - 10) * 1000);
        }
        return accessToken;
    }

    public static String getTicket(){
        if(new Date().getTime() > ticketExpiresTime){
            String result = HttpUtil.get(GET_TICKET_URL.replace("ACCESS_TOKEN", getAccessToken()));
            System.out.println(result);
            JSONObject json = JSON.parseObject(result);
            ticket = (String)json.get("ticket");
            Integer expires_in = (Integer) json.get("expires_in");
            ticketExpiresTime = new Date().getTime() + ((expires_in - 10) * 1000);
        }
        return ticket;
    }



    public static void createMenu(String json){
        String token = HttpUtil.post(GET_MENU_URL.replace("ACCESS_TOKEN", getAccessToken()),json);
        System.out.println(token);
    }

    public static void template(){
        String token = HttpUtil.post(SEND_TEMPLATE_URL.replace("ACCESS_TOKEN", getAccessToken()), "{\"touser\":\"oP_mZwhWlVaMeveZ_KTt9D2MG97Q\",\"template_id\":\"MepHJ0c3W2Ek3JTO9S-1Wq8W4kl0e5Gbue6nOeTIb8E\",\"url\":\"http://weixin.qq.com/download\",\"data\":{\"first\":{\"value\":\"恭喜你购买成功！\",\"color\":\"#173177\"},\"keyword1\":{\"value\":\"巧克力\",\"color\":\"#173177\"},\"keyword2\":{\"value\":\"39.8元\",\"color\":\"#173177\"},\"keyword3\":{\"value\":\"2014年9月22日\",\"color\":\"#173177\"},\"remark\":{\"value\":\"欢迎再次购买！\",\"color\":\"#173177\"}}}");
        System.out.println(token);
    }

    public static void main(String[] args){
       /* String result = HttpUtil.post(GET_SUCAI_URL.replace("ACCESS_TOKEN", getAccessToken()), "{\n" +
                "   \"type\":\"image\",\n" +
                "   \"offset\":1,\n" +
                "   \"count\":1\n" +
                "}");
        System.out.println(result);*/

    }

}
