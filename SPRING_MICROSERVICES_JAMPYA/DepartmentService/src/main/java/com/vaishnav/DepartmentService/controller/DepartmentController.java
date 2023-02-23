package com.vaishnav.DepartmentService.controller;

import com.vaishnav.DepartmentService.entity.Department;
import com.vaishnav.DepartmentService.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        log.info("inside saveDepartment method of department controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/{departmentId}")
    public Department findDepartmentById(@PathVariable Long departmentId) throws Exception {
        log.info("inside findDepartmentById method of department controller");
        return departmentService.findDepartmentById(departmentId);
    }
}
