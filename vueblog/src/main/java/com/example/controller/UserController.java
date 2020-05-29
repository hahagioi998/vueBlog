package com.example.controller;


import com.example.common.lang.Result;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 咕咕咕
 * @since 2020-05-29
 */
@RestController
@RequestMapping("/user")
public class UserController {
    //注入服务
    @Autowired
    UserService userService;

    //get请求
    @GetMapping("/index")
    public Object index(){
        User user =  userService.getById(1L);
        return Result.success(user);
    }

}
