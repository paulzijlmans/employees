package dev.paulzijlmans.springboot.employees.service;

import dev.paulzijlmans.springboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
