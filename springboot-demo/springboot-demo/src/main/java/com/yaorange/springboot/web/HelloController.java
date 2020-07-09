package com.yaorange.springboot.web;

import com.yaorange.springboot.config.UserProperties;
import com.yaorange.springboot.pojo.User;
import com.yaorange.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@Controller
@EnableConfigurationProperties(UserProperties.class)
public class HelloController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserProperties userProperties;
    @GetMapping("hello")
    public @ResponseBody User hello(){
        System.out.println(userProperties.getUser().getUsername());
        userService.save();
        User user = new User();
        user.setName("德华");
        user.setPassword("123");
        return user;
    }


    @GetMapping("/all")
    public String all(ModelMap model) {
        // 查询用户
        List<User> users = this.userService.queryAll();
        // 放入模型
        model.addAttribute("users", users);
        // 返回模板名称（就是classpath:/templates/目录下的html文件名）
        return "users";
    }
}