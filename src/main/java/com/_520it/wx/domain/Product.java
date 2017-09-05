package com._520it.wx.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Product {
	private Long id;

	private String name;

	private BigDecimal salePrice;

	private BigDecimal costPrice;

	private String imageURL;

	private String introduce;

	private String secondImg;

	private Double weight;

}