package com._520it.wx.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 76585 on 2017/9/4.
 */
@Setter
@Getter
@ToString
public class MessageQueryObject extends QueryObject {

    private String name;

    @JsonFormat(pattern = "yy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
    private Date beginTime;

    @JsonFormat(pattern = "yy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
    private Date endTime;

    private Integer type;
}
