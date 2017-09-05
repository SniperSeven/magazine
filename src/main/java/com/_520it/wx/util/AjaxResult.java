package com._520it.wx.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by zmh on 2017/8/21.
 */
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class AjaxResult {
    private boolean success;
    private String msg;
}
