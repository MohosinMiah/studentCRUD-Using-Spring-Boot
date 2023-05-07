package com.studentms.student.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentms.student.entity.Department;
import com.studentms.student.error.DepartmentNotFountException;
import com.studentms.student.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        // TODO Auto-generated method stub
       return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        // TODO Auto-generated method stub
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFountException {
        // TODO Auto-generated method stub
        Optional<Department> department = departmentRepository.findById(departmentId);

        if( !department.isPresent() )
        {
            throw new DepartmentNotFountException("Department Not Found");
            
        }

        return department.get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
        // TODO Auto-generated method stub
        departmentRepository.deleteById(departmentId);

        return null;
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        // TODO Auto-generated method stub
        Department dpt =  departmentRepository.findById(departmentId).get();

        if( Objects.nonNull( department.getDepartmentName() ) && !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            dpt.setDepartmentName(department.getDepartmentName());
        }

        if( Objects.nonNull( department.getDepartmentAddress() ) && !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            dpt.setDepartmentAddress(department.getDepartmentAddress());
        } 

        if( Objects.nonNull( department.getDepartmentCode() ) && !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            dpt.setDepartmentCode(department.getDepartmentCode());
        } 
        return departmentRepository.save(dpt);
        
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        // TODO Auto-generated method stub
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
    

}
