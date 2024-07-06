package com.srsvmj.employee_rest_app.repository;

import com.srsvmj.employee_rest_app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
