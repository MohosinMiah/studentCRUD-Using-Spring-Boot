package com.studentms.student.controller;

import static org.mockito.Answers.valueOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.jayway.jsonpath.JsonPath;
import com.studentms.student.entity.Department;
import com.studentms.student.error.DepartmentNotFountException;
import com.studentms.student.service.DepartmentService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;



    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Dhaka")
                .departmentCode("CSE001")
                .departmentName("CSE")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Dhaka")
                .departmentCode("CSE001")
                .departmentName("CSE")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "\t\"departmentName\":\"CSE\",\n" +
                "\t\"departmentAddress\":\"Dhaka\",\n" +
                "\t\"departmentCode\":\"CSE001\"\n" +
                "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.departmentName").
                value(department.getDepartmentName()));
    }



}
