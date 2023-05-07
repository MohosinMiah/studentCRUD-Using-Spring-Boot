package com.studentms.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentms.student.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long >{
    
    public Department findByDepartmentName(String name);

    public Department findByDepartmentNameIgnoreCase(String name);
}
