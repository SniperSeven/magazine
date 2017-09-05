package com._520it.wx.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class Menu {
    private Long id;

    private String name;

    private String type;

    private String key;

    private String url;

    private List<Menu> sub_button;

    private Menu parent;

    private String media_id;

    private Boolean state;

}