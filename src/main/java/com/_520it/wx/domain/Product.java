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

    private BigDecimal weight;

    private String detailImg;

    private String inHead;

    public BigDecimal getWeight() {
        if (weight != null) {
            weight.setScale(2);
        }
        return weight;
    }

    public boolean equals(Product product) {
        return this == null ? (product == null ? true : false) : (product == null ? false : this.id == product.getId());
    }


}