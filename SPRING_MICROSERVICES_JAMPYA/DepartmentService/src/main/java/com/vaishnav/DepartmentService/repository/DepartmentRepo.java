package com.vaishnav.DepartmentService.repository;

import com.vaishnav.DepartmentService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Department findByDepartmentId(Long departmentId);
}
