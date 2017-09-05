package com._520it.wx.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class Client {
    private Long id;

    private String name;

    private String address;

    private String openId;

    private String tel;

    @JsonFormat(pattern = "yy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date concernTime;

    @JsonFormat(pattern = "yy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date cancelConcernTime;

    private Boolean status;

}