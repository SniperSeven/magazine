package com._520it.wx.mapper;

import com._520it.wx.domain.Client;
import com._520it.wx.domain.Material;
import com._520it.wx.query.ClientQueryObject;
import com._520it.wx.query.QueryObject;

import java.util.List;

public interface MaterialMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Material record);

    Material selectByPrimaryKey(Long id);

    List<Material> selectAll();

    int updateByPrimaryKey(Material record);

    List<Material> getDataList(QueryObject qo);

    int getTotalCount(QueryObject qo);
}