package com._520it.wx.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by cyf on 2017/9/4.
 */
@Getter
@Setter
@ToString
public class BillQueryObject extends QueryObject {
    @JsonFormat(pattern = "yy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date beginSaleDate;

    @JsonFormat(pattern = "yy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date endSaleDate;

    private String state="";
}
