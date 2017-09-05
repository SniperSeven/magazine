package com._520it.wx.web.controller;

import com._520it.wx.domain.Message;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.MessageQueryObject;
import com._520it.wx.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zmh on 2017/8/21.
 */
@Controller
public class MessageController extends BaseController{

    @Autowired
    private IMessageService service;
    
    @RequestMapping("/message_view")
    public String message() {
        return "message";
    }

    @RequestMapping("/message_list")
    @ResponseBody
    public PageResult list(MessageQueryObject qo) {
        return service.pageQuery(qo);
    }

    @RequestMapping("/message_getOne")
    @ResponseBody
    public Message getOne(Long id) {

        return service.selectByPrimaryKey(id);
    }

    @RequestMapping("/message_listAll")
    @ResponseBody
    public List<Message> listAll() {
        return service.selectAll();
    }
}
