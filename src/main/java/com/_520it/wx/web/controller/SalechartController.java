package com._520it.wx.web.controller;

import com._520it.wx.domain.Salechart;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.SalechartQueryObject;
import com._520it.wx.service.ISalechartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zmh on 2017/8/21.
 */
@Controller
public class SalechartController{

    @Autowired
    private ISalechartService service;
    
    @RequestMapping("/saleChart_view")
    public String saleChart() {
        return "saleChart";
    }

    @RequestMapping("/saleChart_list")
    @ResponseBody
    public PageResult list(SalechartQueryObject qo) {
        return service.pageQuery(qo);
    }

    @RequestMapping("/saleChart_getOne")
    @ResponseBody
    public Salechart getOne(Long id) {

        return service.selectByPrimaryKey(id);
    }

    @RequestMapping("/saleChart_listAll")
    @ResponseBody
    public List<Salechart> listAll() {
        return service.selectAll();
    }
}
