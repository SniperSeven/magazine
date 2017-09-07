package com._520it.wx.web.controller;

import com._520it.wx.domain.Product;
import com._520it.wx.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wall on 2017/9/5.
 */
@Controller
public class ShoppingController {

    @Autowired
    private IProductService service;

    @RequestMapping("/comment")
    public String comment(HttpServletRequest request,Long id){
        Product product = service.selectByPrimaryKey(id);
        System.out.println(product);
        request.setAttribute("product",product);
        return "comment";
    }


}
