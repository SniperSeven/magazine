package com._520it.wx.service;

import com._520it.wx.domain.Salechart;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.QueryObject;

import java.util.List;

/**
 * Created by 76585 on 2017/9/4.
 */
public interface ISalechartService {
    Salechart selectByPrimaryKey(Long id);

    List<Salechart> selectAll();

    PageResult pageQuery(QueryObject qo);
}
