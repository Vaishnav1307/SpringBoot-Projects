package com.vaishnav.DepartmentService.service;

import com.vaishnav.DepartmentService.entity.Department;
import com.vaishnav.DepartmentService.repository.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment(Department department) {
      log.info("inside saveDepartment of department service");
        return departmentRepo.save(department);
    }

    public Department findDepartmentById(Long departmentId) throws Exception {
        log.info("inside findDepartmentById of department service");
        return departmentRepo.findByDepartmentId(departmentId);
    }
}
