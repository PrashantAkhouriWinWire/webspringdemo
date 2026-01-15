package com.webspringboot.webspringdemo.service;

import com.webspringboot.webspringdemo.entity.Employee;
import com.webspringboot.webspringdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    // Get employee by ID
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }
    
    // Get employee by email
    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
    
    // Get employees by department
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
    
    // Get employees by position
    public List<Employee> getEmployeesByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }
    
    // Get employees with salary greater than specified amount
    public List<Employee> getEmployeesWithSalaryGreaterThan(double salary) {
        return employeeRepository.findEmployeesWithSalaryGreaterThan(salary);
    }
    
    // Save or update employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    // Update employee
    public Employee updateEmployee(int id, Employee employeeDetails) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setPhoneNumber(employeeDetails.getPhoneNumber());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setSalary(employeeDetails.getSalary());
            employee.setPosition(employeeDetails.getPosition());
            employee.setHireDate(employeeDetails.getHireDate());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
    
    // Delete employee by ID
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
    
    // Get total number of employees
    public long getTotalEmployeeCount() {
        return employeeRepository.count();
    }
}
