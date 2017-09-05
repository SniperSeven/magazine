package com._520it.wx.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by zmh on 2017/8/21.
 */
@Getter
@Setter@ToString
public class QueryObject {
    private int page = 1;
    private int rows = 10;
    private Long id;
    public int getStart(){
        return (page-1)*rows;
    }
}
