package com.studentms.student.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @Setter
// @Getter
public class Department {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long departmentId;

    @NotNull( message = "Department name can not be empty")
    @Length(max = 22, min = 2)
    // @Future
    // @FutureOrPresent
    // @Size

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


    // public Long getDepartmentId() {
    //     return departmentId;
    // }
    // public void setDepartmentId(Long departmentId) {
    //     this.departmentId = departmentId;
    // }
    // public String getDepartmentName() {
    //     return departmentName;
    // }
    // public void setDepartmentName(String departmentName) {
    //     this.departmentName = departmentName;
    // }
    // public String getDepartmentAddress() {
    //     return departmentAddress;
    // }
    // public void setDepartmentAddress(String departmentAddress) {
    //     this.departmentAddress = departmentAddress;
    // }
    // public String getDepartmentCode() {
    //     return departmentCode;
    // }
    // public void setDepartmentCode(String departmentCode) {
    //     this.departmentCode = departmentCode;
    // }

    // public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
    //     this.departmentId = departmentId;
    //     this.departmentName = departmentName;
    //     this.departmentAddress = departmentAddress;
    //     this.departmentCode = departmentCode;
    // }

    // public Department() {

    // }

    // @Override
    // public String toString() {
    //     return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
    //             + ", departmentAddress=" + departmentAddress + ", departmentCode=" + departmentCode + "]";
    // }

}
