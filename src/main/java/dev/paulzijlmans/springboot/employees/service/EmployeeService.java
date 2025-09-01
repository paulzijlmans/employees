package dev.paulzijlmans.springboot.employees.service;

import dev.paulzijlmans.springboot.employees.entity.Employee;
import dev.paulzijlmans.springboot.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(long id);

    Employee save(EmployeeRequest employeeRequest);

    Employee update(long id, EmployeeRequest employeeRequest);

    void deleteById(long id);
}
