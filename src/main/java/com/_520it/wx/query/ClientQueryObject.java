package com._520it.wx.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 76585 on 2017/9/5.
 */
@Setter
@Getter
@ToString
public class ClientQueryObject extends QueryObject {

    private Boolean status;

    @JsonFormat(pattern = "yy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date beginConcernTime;

    @JsonFormat(pattern = "yy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date endConcernTime;
}
