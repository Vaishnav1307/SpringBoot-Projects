package com.vaishnav.UserService.controller;

import com.vaishnav.UserService.VO.ResponseTemplateVo;
import com.vaishnav.UserService.entity.User;
import com.vaishnav.UserService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        log.info("inside saveUser of userController");
        return userService.saveUser(user);
    }

    @GetMapping("/get/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside getUserWithDepartment of userController");
        return userService.getUserWithDepartment(userId);
    }
}
