package com._520it.wx.mapper;

import com._520it.wx.domain.Menu;
import com._520it.wx.query.QueryObject;

import java.util.List;

public interface MenuMapper {
  /*  int deleteByPrimaryKey(Long id);

    int insert(Menu menu);*/

    Menu selectByPrimaryKey(Long id);

    Menu selectByName(String name);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu menu);

    List<Menu> getDataList(QueryObject qo);

    int getTotalCount(QueryObject qo);

    List<Menu> getbuttons();

    List<Menu> getsubbuttons();

    void disable(Long id);

    void enable(Long id);


}