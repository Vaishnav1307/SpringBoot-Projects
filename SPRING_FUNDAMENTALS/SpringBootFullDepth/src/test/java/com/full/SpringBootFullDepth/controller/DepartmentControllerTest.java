package com.full.SpringBootFullDepth.controller;

import com.full.SpringBootFullDepth.entity.Department;
import com.full.SpringBootFullDepth.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Pune")
                .departmentCode("Mh-12")
                .departmentName("It")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Pune")
                .departmentCode("Mh-12")
                .departmentName("It")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"departmentName\":\"It\",\n" +
                                "    \"departmentAddress\":\"Pune\",\n" +
                                "    \"departmentCode\":\"Mh-12\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartment() throws Exception {
        Mockito.when(departmentService.fetchDepartment(1L))
                .thenReturn(Optional.ofNullable(department));

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}