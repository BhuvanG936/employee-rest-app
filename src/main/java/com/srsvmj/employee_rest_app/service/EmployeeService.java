package com.srsvmj.employee_rest_app.service;

import com.srsvmj.employee_rest_app.entity.Employee;
import com.srsvmj.employee_rest_app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Optional<Employee> getEmployeeById(Long employeeId) {
      return   employeeRepository.findById(employeeId);
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    public boolean updateEmployee(Long employeeId, Employee employee) {

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if(employeeOptional.isPresent()){

            Employee employeeToUpdate = employeeOptional.get();

            employeeToUpdate.setEmployeeId(employee.getEmployeeId());
            employeeToUpdate.setEmployeeName(employee.getEmployeeName());
            employeeToUpdate.setEmployeeAddress(employee.getEmployeeAddress());
            employeeToUpdate.setEmployeeProjects(employee.getEmployeeProjects());
            employeeToUpdate.setReportingTo(employee.getReportingTo());

            employeeRepository.save(employeeToUpdate);
            return  true;
        }else{
            return  false;
        }
    }

    public boolean deleteEmployeeById(Long employeeId) {

        if(employeeRepository.existsById(employeeId)){

            employeeRepository.deleteById(employeeId);
            return true;
        }else{
            return false;
        }
    }
}
