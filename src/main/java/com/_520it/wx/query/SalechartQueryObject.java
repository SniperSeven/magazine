package com._520it.wx.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Created by 76585 on 2017/9/4.
 */
@Setter
@Getter
@ToString
public class SalechartQueryObject extends QueryObject{
    private BigDecimal maxValue;
    private BigDecimal minValue;

    private String keyword;
}
