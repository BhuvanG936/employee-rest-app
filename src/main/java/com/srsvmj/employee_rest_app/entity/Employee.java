package com.srsvmj.employee_rest_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="tbl_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="employee_address")
    private String employeeAddress;

    @Column(name="employee_projects")
    private String employeeProjects;

    @Column(name="reporting_to")
    private String reportingTo;
}
