package com._520it.wx.page;

import lombok.*;

import java.util.List;

/**
 * Created by zmh on 2017/8/21.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {
    private int total;
    private List<?> rows;
}
