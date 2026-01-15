package com.webspringboot.webspringdemo.repository;

import com.webspringboot.webspringdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // Find employee by email
    Optional<Employee> findByEmail(String email);
    
    // Find employees by department
    List<Employee> findByDepartment(String department);
    
    // Find employees by position
    List<Employee> findByPosition(String position);
    
    // Custom query to find employees with salary greater than specified amount
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary ORDER BY e.salary DESC")
    List<Employee> findEmployeesWithSalaryGreaterThan(@Param("salary") double salary);
    
    // Custom query to find employees by first and last name
    @Query("SELECT e FROM Employee e WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :firstName, '%')) " +
           "AND LOWER(e.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))")
    List<Employee> findByFirstNameAndLastNameContaining(@Param("firstName") String firstName, 
                                                        @Param("lastName") String lastName);
}
