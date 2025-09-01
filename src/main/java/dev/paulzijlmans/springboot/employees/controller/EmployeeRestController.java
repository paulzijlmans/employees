package dev.paulzijlmans.springboot.employees.controller;

import dev.paulzijlmans.springboot.employees.dao.EmployeeDAO;
import dev.paulzijlmans.springboot.employees.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
