package com.vaishnav.UserService.service;

import com.vaishnav.UserService.VO.Department;
import com.vaishnav.UserService.VO.ResponseTemplateVo;
import com.vaishnav.UserService.entity.User;
import com.vaishnav.UserService.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside saveUser of userController");
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        log.info("inside getUserWithDepartment of userController");
        ResponseTemplateVo vo = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
