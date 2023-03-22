package com.Administration.Pro.Administration.Pro.Services;

import com.Administration.Pro.Administration.Pro.Repository.EmployeeRepository;
import com.Administration.Pro.Administration.Pro.Webdomains.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Long totalEmployees() {
        Long totalEmployees = employeeRepository.count();
        return totalEmployees;
    }
}
