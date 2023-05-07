package com.studentms.student.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.studentms.student.entity.Department;
import com.studentms.student.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    // @BeforeAll
    void setUp()
    {
        Department department =
            Department.builder().departmentName("CSE")
                .departmentAddress("Dhaka")
                .departmentCode("CSE001")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CSE")).thenReturn(department);
    }


    @Test
    void testDeleteDepartmentById() {

    }

    @Test
    void testFetchDepartmentById() {

    }

    @Test
    @DisplayName("Get Department Based On Department Name")
    // @Disabled
    void testFetchDepartmentByName() {
        
        String departmentName = "CSE";
        Department department = departmentService.fetchDepartmentByName("CSE");
        assertEquals( departmentName,department.getDepartmentName() );
    }

    @Test
    void testFetchDepartmentList() {

    }

    @Test
    void testSaveDepartment() {

    }

    @Test
    void testUpdateDepartment() {

    }
}
