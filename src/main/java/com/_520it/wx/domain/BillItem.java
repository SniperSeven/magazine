package com._520it.wx.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class BillItem {
	private Long id;

	private Long billId;

	private Product product;

	private BigDecimal number;

	private BigDecimal smallAccount;

}