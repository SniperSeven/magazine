package com._520it.wx.mapper;

import java.util.List;
import com._520it.wx.domain.Salechart;
import com._520it.wx.query.QueryObject;

public interface SalechartMapper {

    Salechart selectByPrimaryKey(Long id);

    List<Salechart> selectAll();

    int getTotalCount(QueryObject qo);

    List<Salechart> getListData(QueryObject qo);

    int insert(Salechart record);
    /*int deleteByPrimaryKey(Long id);


    int updateByPrimaryKey(Salechart record);*/
}
