package com._520it.wx.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Salechart {
    private Long id;

    //订单编号
    private String sn;

    private BigDecimal number;

    private BigDecimal costprice;

    private BigDecimal saleprice;

    private BigDecimal profit;

    @JsonFormat(pattern = "yy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
    private Date saletime;

}