package dev.paulzijlmans.springboot.employees.service;

import dev.paulzijlmans.springboot.employees.dao.EmployeeDAO;
import dev.paulzijlmans.springboot.employees.entity.Employee;
import dev.paulzijlmans.springboot.employees.request.EmployeeRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(long id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest) {
        return employeeDAO.save(convertToEmployee(0, employeeRequest));
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        return employeeDAO.save(convertToEmployee(id, employeeRequest));
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        employeeDAO.deleteById(id);
    }

    private Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {
        return new Employee(id, employeeRequest.firstName(), employeeRequest.lastName(), employeeRequest.email());
    }
}
