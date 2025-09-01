package dev.paulzijlmans.springboot.employees.dao;

import dev.paulzijlmans.springboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
