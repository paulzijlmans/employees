package dev.paulzijlmans.springboot.employees.service;

import dev.paulzijlmans.springboot.employees.dao.EmployeeRepository;
import dev.paulzijlmans.springboot.employees.entity.Employee;
import dev.paulzijlmans.springboot.employees.request.EmployeeRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest) {
        return employeeRepository.save(convertToEmployee(0, employeeRequest));
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        return employeeRepository.save(convertToEmployee(id, employeeRequest));
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    private Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {
        return new Employee(id, employeeRequest.firstName(), employeeRequest.lastName(), employeeRequest.email());
    }
}
