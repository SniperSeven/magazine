package com._520it.wx.web.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zmh on 2017/8/21.
 */
public class BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    /*@ExceptionHandler(UnauthorizedException.class)
    public void handlerException(HandlerMethod method,HttpServletResponse response) throws IOException {
        ResponseBody annotation = method.getMethodAnnotation(ResponseBody.class);
        System.out.println(annotation);
        if(annotation != null){
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(new ObjectMapper().writeValueAsString(new AjaxResult(false,"没有权限")));
        }else {
            response.sendRedirect("/noPermission.jsp");}

    }*/
}
