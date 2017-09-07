package com._520it.wx.web.controller;

import com._520it.wx.domain.Client;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.ClientQueryObject;
import com._520it.wx.service.IClientService;
import com._520it.wx.service.IMenuService;
import com._520it.wx.util.AjaxResult;
import com._520it.wx.util.HttpUtil;
import com._520it.wx.util.WeixinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zmh on 2017/8/21.
 */
@Controller
public class ClientController extends BaseController {

    //
    // @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private IClientService service;

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/client_view")
    public String client() {
        return "client";
    }

    @RequestMapping("/client_list")
    @ResponseBody
    public PageResult list(ClientQueryObject qo) {
        return service.pageQuery(qo);
    }

    @RequestMapping("/client_mass")
    @ResponseBody
    public List<String> mass(@RequestParam(value = "openId[]")String[] openId, String mediaId) {
        String mass = "{\n" +
                "   \"touser\":[\n" +
                "    OPENID\n" +
                "   ],\n" +
                "   \"mpnews\":{\n" +
                "      \"media_id\":\"MEDIA_ID\"\n" +
                "   },\n" +
                "    \"msgtype\":\"mpnews\"，\n" +
                "    \"send_ignore_reprint\":1\n" +
                "}\n";
        String str = "";
        for(int i = 0; i < openId.length;i++){
            str += "\"" + openId[i] + "\",";
            if(i == openId.length -1){
                str += "\"" + openId[i] + "\"";
            }
        }
        String result = HttpUtil.post(WeixinUtil.MASS_URL.replace("ACCESS_TOKEN", WeixinUtil.getAccessToken()), mass.replace("OPENID", str).replace("MEDIA_ID", mediaId));
        System.out.println(result);
        return null;
    }

    @RequestMapping("/client_listAll")
    @ResponseBody
    public List<Client> listAll() {
        return service.selectAll();
    }

    @RequestMapping("/client_save")
    @ResponseBody
    public AjaxResult save(Client r) {
        try {
            service.insert(r);
            return new AjaxResult(true, "客户保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false, "客户保存失败");
        }
    }

    @RequestMapping("/client_delete")
    @ResponseBody
    public AjaxResult del(Long id) {
        try {
            service.deleteByPrimaryKey(id);
            return new AjaxResult(true, "客户删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false, "客户删除失败");
        }
    }

    @RequestMapping("/client_edit")
    @ResponseBody
    public AjaxResult edit(Client client) {
        try {
            service.updateByPrimaryKey(client);
            return new AjaxResult(true, "客户编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false, "客户编辑失败");
        }
    }
}
