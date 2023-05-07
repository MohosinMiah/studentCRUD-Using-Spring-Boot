package com.studentms.student.controller;

import java.util.List;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentms.student.entity.Department;
import com.studentms.student.error.DepartmentNotFountException;
import com.studentms.student.service.DepartmentService;

import ch.qos.logback.classic.Logger;
import jakarta.validation.Valid;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        
        return departmentService.saveDepartment( department );
    }


    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    
    @GetMapping("/department/{id}")
    public Department fetchDepartmentById( @PathVariable("id") Long departmentId ) throws DepartmentNotFountException 
    {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById( @PathVariable("id") Long departmentId )
    {
        departmentService.deleteDepartmentById(departmentId);
        return "Successfully Deleted";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department ) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName ){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
