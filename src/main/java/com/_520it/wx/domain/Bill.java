package com._520it.wx.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Bill {
	private Long id;

	private String sn;

	@JsonFormat(pattern = "yy-MM-dd",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date saleDate;

	private BigDecimal costPrice;

	private BigDecimal totalPrice;

	private BigDecimal totalNumber;

	private Client client;

	private String comment;

	private String state;

	private List<BillItem> items = new ArrayList<>();

}