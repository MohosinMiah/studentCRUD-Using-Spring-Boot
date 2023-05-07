package com.studentms.student.service;

import java.util.List;

import com.studentms.student.entity.Department;
import com.studentms.student.error.DepartmentNotFountException;

public interface DepartmentService {

   public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFountException;

    public String deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);


    
}
