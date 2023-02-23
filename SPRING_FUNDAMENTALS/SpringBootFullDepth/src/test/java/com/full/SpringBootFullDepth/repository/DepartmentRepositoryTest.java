package com.full.SpringBootFullDepth.repository;

import com.full.SpringBootFullDepth.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department build = Department.builder()
                .departmentName("It")
                .departmentCode("Yerawada")
                .departmentAddress("Data Economy")
                .build();

        entityManager.persist(build);
    }

    @Test
    public void findByIdPositive(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"It");
    }
}