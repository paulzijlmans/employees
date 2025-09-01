package dev.paulzijlmans.springboot.employees.controller;

import dev.paulzijlmans.springboot.employees.entity.Employee;
import dev.paulzijlmans.springboot.employees.request.EmployeeRequest;
import dev.paulzijlmans.springboot.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Rest API Endpoints", description = "Operations related to employees.")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees.")
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Get single employees", description = "Retrieve a single employee.")
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable @Min(1) long employeeId) {
        return employeeService.findById(employeeId);
    }

    @Operation(summary = "Create a new employee", description = "Add a new employee.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.save(employeeRequest);
    }

    @Operation(summary = "Update an employee", description = "Update the details of a current employee.")
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable @Min(value = 1) long employeeId,
                                   @Valid @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.update(employeeId, employeeRequest);
    }

    @Operation(summary = "Delete a employee", description = "Remove an employee.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable @Min(value = 1) long employeeId) {
        employeeService.deleteById(employeeId);
    }
}
