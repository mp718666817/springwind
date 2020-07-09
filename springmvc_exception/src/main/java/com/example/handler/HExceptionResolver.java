package com.example.handler;

import com.example.exception.SysException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv = new ModelAndView();
        SysException e = null;
        if (ex instanceof SysException){
            e = (SysException)ex;
        }
        else
        {
            e = new SysException("系统维护，请稍后");
        }
        System.out.println(e.getMessage());
        mv.addObject("errorMsg",e.getMessage());
        httpServletRequest.setAttribute("errorMsg",e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
