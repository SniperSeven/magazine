package com._520it.wx.service.impl;

import com._520it.wx.domain.Bill;
import com._520it.wx.domain.Salechart;
import com._520it.wx.mapper.SalechartMapper;
import com._520it.wx.page.PageResult;
import com._520it.wx.query.QueryObject;
import com._520it.wx.service.ISalechartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by 76585 on 2017/9/4.
 */
@Service
public class SalechartServiceImpl implements ISalechartService{

    @Autowired
    private SalechartMapper mapper;



    @Override
    public Salechart selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Salechart> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public PageResult pageQuery(QueryObject qo) {
        int totalCount = mapper.getTotalCount(qo);
        if (totalCount==0){
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<Salechart> listData = mapper.getListData(qo);
        return new PageResult(totalCount,listData);
    }

}
