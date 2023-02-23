package com.full.SpringBootFullDepth.service;

import com.full.SpringBootFullDepth.entity.Department;
import com.full.SpringBootFullDepth.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentName("Mechanical")
                .departmentAddress("Upper")
                .departmentCode("Mh-12")
                .build();

        Mockito.when(departmentRepository.findById(1L)).thenReturn(Optional.ofNullable(department));
    }

    @Test
    @DisplayName("Get data based on valid id")
    @Disabled
    public void fetchByIdPositive(){
        Long id = 1L;
        Optional<Department> department = departmentService.fetchDepartment(id);
        assertEquals(id,department.get().getDepartmentId());
    }
}