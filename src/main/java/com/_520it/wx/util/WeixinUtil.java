package com._520it.wx.util;

import com._520it.wx.domain.Material;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
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

    public static final String MASS_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";

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

    public static void template(String OPENID,String NAME,String TOTALPRICE){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String nowdate = sdf.format(new Date());
        String replace = ContentUtil.template.replace("OPENID", OPENID).replace("NAME", NAME).replace("TOTALPRICE", TOTALPRICE).replace("NOWDATE", nowdate);
        System.out.println(replace);
        String token = HttpUtil.post(SEND_TEMPLATE_URL.replace("ACCESS_TOKEN", getAccessToken()),replace );
        System.out.println(token);
    }
    public static String getOpenid(String code) {
        String url = GET_WEB_ACCESSTOKEN_URL.replace("APPID", APPID)
                .replace("SECRET", APPSECRET)
                .replace("CODE", code);
        String result = HttpUtil.get(url);
        JSONObject jsonObject = JSON.parseObject(result);
        return (String) jsonObject.get("openid");
    }

    public static void mass(){
        HttpUtil.post(MASS_URL.replace("ACCESS_TOKEN",getAccessToken()),"{\"touser\":[\"OPENID1\",\"OPENID2\"],\"mpnews\":{\"media_id\":\"123dsdajkasd231jhksad\"},\"msgtype\":\"mpnews\",\"send_ignore_reprint\":0}");
    }

   /* public static void messagePrivate(String accesstoken, String touser, List<WxArticle> wxArticles) throws WexinReqException {

        if (accesstoken != null) {
            String requestUrl = message_preview_url.replace("ACCESS_TOKEN", accesstoken);
            try {
                String mediaId = getMediaId(accesstoken, wxArticles);
                JSONObject obj = new JSONObject();
                JSONObject mpnews = new JSONObject();
                obj.put("touser", touser);
                obj.put("msgtype", "mpnews");
                mpnews.put("media_id", mediaId);
                obj.put("mpnews", mpnews);
                JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", obj.toString());
                //System.out.println("微信返回的结果：" + result.toString());
            } catch (Exception e) {

                throw new WexinReqException(e);
            }
        } else {
            throw new WexinReqException("accesstoken 为空，请检查！");
        }
    }*/

    public static void main(String[] args){
        /*String result = HttpUtil.post(GET_SUCAI_URL.replace("ACCESS_TOKEN", getAccessToken()), "{\n" +
                "   \"type\":\"image\",\n" +
                "   \"offset\":1,\n" +
                "   \"count\":5\n" +
                "}");
        System.out.println(result);*/
        JSONObject resultJSON = HttpUtil.addMaterialEver("C:/Users/zmh/Desktop/每日视频和笔/大神班资料/23.微信公众号开发/资料/weixin/src/main/webapp/121.jpg","image", WeixinUtil.getAccessToken());

    }

}
