package com.srsvmj.employee_rest_app.controller;

import com.srsvmj.employee_rest_app.entity.Employee;
import com.srsvmj.employee_rest_app.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //1. To get all the employees, URL: http://localhost:8080/employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //2. To Retrieve Employee by id, URL: http://localhost:8080/employees/3
    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    //3. TO Create new Employee, URL: http://localhost:8080/employees
    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){

        employeeService.createEmployee(employee);

        return new ResponseEntity<>("Employee Created Successfully", HttpStatus.CREATED);
    }

    //4. To Update an Employee, URL: http://localhost:8080/employees/6
    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee){

        boolean isEmployeeUpdated = employeeService.updateEmployee(employeeId, employee);

        if (isEmployeeUpdated){
            return new ResponseEntity<>("Employee Updated Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Employee Not Updated", HttpStatus.NOT_FOUND);
        }
    }

    //5. TO Delete an Employee by ID, URL: http://localhost:8080/employees/6
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long employeeId){

        boolean isEmployeeDeleted = employeeService.deleteEmployeeById(employeeId);

        if(isEmployeeDeleted){
            return new ResponseEntity<>("Employee Deleted Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Employee Not Deleted", HttpStatus.NOT_FOUND);
        }
    }
}
