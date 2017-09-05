package com._520it.wx.web.controller;

import com._520it.wx.page.PageResult;
import com._520it.wx.query.QueryObject;
import com._520it.wx.service.IMenuService;
import com._520it.wx.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by zmh on 2017/9/4.
 */
@Controller
public class MenuController {
    @Autowired
    private IMenuService service;

    @RequestMapping("/menu_view")
    public String view(){
        return "menu";
    }

    @RequestMapping("/menu_list")
    @ResponseBody
    public PageResult list(QueryObject qo){
        return service.pageQuery(qo);
    }

    @RequestMapping("/menu_create")
    @ResponseBody
    public AjaxResult delete(){
        try{
            service.createMenu();
            return new AjaxResult(true,"菜单生成成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"菜单生成失败");
        }
    }

}
