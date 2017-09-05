package com._520it.wx.domain;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter
public class Material {
    private Long id;

    private String title;

    private String thumb_media_id;

    private String author;

    private String digest;

    private String show_cover_pic;

    private String content;

    private String content_source_url;

    private Product product;

    private BigDecimal salePrice;
}