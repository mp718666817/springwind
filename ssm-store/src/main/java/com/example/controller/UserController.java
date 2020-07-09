package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.MyDateConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public String login(HttpServletRequest request,HttpServletResponse response){
        try {
            //判断验证码
            String sessionYzm = (String) request.getSession().getAttribute("code");
            String yzm = request.getParameter("yzm");
            if (null != yzm && !yzm.isEmpty() && yzm.equals(sessionYzm)) {
                //判断账号密码(已激活)
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println(username+password);
                boolean isOk = userService.login(username, password);
                System.out.println(isOk);
                if(isOk)
                {
                    //登录成功, 判断是否记住用户名
                    String remeberUsername = request.getParameter("remeberUsername");
                    if(remeberUsername!=null)
                    {
                        //新建cookie
                        Cookie cookie = new Cookie("remeberUsername",username);
                        cookie.setMaxAge(60*60*24*7);  //记住用户名1周
                        response.addCookie(cookie);
                    }
                    //判断是否自动登录
                    String autoLogin = request.getParameter("autoLogin");
                    if(autoLogin!=null)
                    {
                        //新建cookie
                        Cookie cookie = new Cookie("autoLogin",username+"&&&"+password);
                        cookie.setMaxAge(60*60*24*7);
                        response.addCookie(cookie);
                    }

                    //保存user到session
                    User user = userService.findByName(username);
                    request.getSession().setAttribute("user",user);
                }
                else
                {
                    //反之 提示信息
                    request.setAttribute("errorMsg","账号密码错误");
                    return "login";
                }

            }
            else
            {
                //no
                //提示信息
                request.setAttribute("errorMsg","验证码错误");
                return "login";
            }
        } catch (Exception e) {
            // e.printStackTrace();
            //反之 提示信息
            request.setAttribute("errorMsg","系统故障! 请咨询400:)");
            return "login";
        }

        return "index";
    }
    @RequestMapping("/register")
    public ModelAndView register(@RequestParam String code,String yzm,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(null!=yzm && !yzm.isEmpty() && yzm.equals(code)){
            //用户填写的验证码与会话中存储的验证码相同(大小写)
            //获取表单数据
            User user = new User();
            try {
                ConvertUtils.register(new MyDateConverter(), Date.class);
                BeanUtils.populate(user,request.getParameterMap());

                boolean ok = userService.register(user);
                if(!ok){
                    mv.addObject("errorMsg","注册失败!");
                    mv.setViewName("register");
                    return mv;
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            mv.addObject("errorMsg","验证码错误");
            mv.setViewName("register");
            return mv;
        }

        return new ModelAndView("redirect:login.jsp");

    }

}
