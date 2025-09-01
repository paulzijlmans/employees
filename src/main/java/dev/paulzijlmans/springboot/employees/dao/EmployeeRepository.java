package dev.paulzijlmans.springboot.employees.dao;

import dev.paulzijlmans.springboot.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
