package com._520it.wx.service;

import com._520it.wx.domain.Menu;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.QueryObject;

import java.util.List;

/**
 * Created by zmh on 2017/9/4.
 */
public interface IMenuService {
    /*int deleteByPrimaryKey(Long id);

    int insert(Menu menu);*/

    Menu selectByPrimaryKey(Long id);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu menu);

    PageResult pageQuery(QueryObject qo);

    List<Menu> getbuttons();

    void disable(Long id);

    void enable(Long id);

    void createMenu();
}
