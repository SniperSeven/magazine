package com._520it.wx.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter@Setter
public class Material {
    private Long id;

    private String title;

    private String thumb_media_id;

    private String author;

    private String digest;

    private Boolean show_cover_pic;

    private String content;

    private String content_source_url;

    private Product product;

    private BigDecimal salePrice;

    private String mediaId;

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumb_media_id='" + thumb_media_id + '\'' +
                ", author='" + author + '\'' +
                ", digest='" + digest + '\'' +
                ", show_cover_pic=" + show_cover_pic +
                ", content_source_url='" + content_source_url + '\'' +
                ", product=" + product +
                ", salePrice=" + salePrice +
                ", mediaId='" + mediaId + '\'' +
                '}';
    }
}