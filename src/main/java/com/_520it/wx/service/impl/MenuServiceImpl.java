package com._520it.wx.service.impl;

import com._520it.wx.domain.Menu;
import com._520it.wx.mapper.MenuMapper;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.QueryObject;

import com._520it.wx.service.IMenuService;
import com._520it.wx.util.WeixinUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cyf on 2017/9/4.
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper mapper;

   /* @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu log) {

        int count = mapper.insert(log);
        return count;
    }*/

    @Override
    public Menu selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Menu selectByName(String name) {
        return mapper.selectByName(name);
    }

    @Override
    public List<Menu> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Menu log) {
        return mapper.updateByPrimaryKey(log);
    }

    @Override
    public PageResult pageQuery(QueryObject qo) {
        List<Menu> listData = mapper.getDataList(qo);
        int totalCount = mapper.getTotalCount(qo);
        return new PageResult(totalCount, listData);
    }

    @Override
    public List<Menu> getbuttons() {
        return mapper.getbuttons();
    }

    @Override
    public void disable(Long id) {
        mapper.disable(id);
    }

    @Override
    public void enable(Long id) {
        mapper.enable(id);
    }

    @Override
    public void createMenu() {
        List<Menu> menus = mapper.getbuttons();
        Map<String,List<Menu>> map = new HashMap<>();
        map.put("button",menus);
        //System.out.println(JSON.toJSONString(map));
        WeixinUtil.createMenu(JSON.toJSONString(map));
    }


}