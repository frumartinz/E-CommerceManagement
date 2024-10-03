package com.Administration.Pro.Administration.Pro.Services;

import com.Administration.Pro.Administration.Pro.Repository.EmployeeRepository;
import com.Administration.Pro.Administration.Pro.Webdomains.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public List<Employee> searchEmployee(String query) {
        return employeeRepository.findBySurnameContainingIgnoreCase(query);
    }

    public Employee saveEmployee(Employee employee) {

//        if (employee.getSurname().length() < 7) {
//            System.out.println("Surname too short");
//        } else {
//            employee.getSurname();
//        }

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Long totalEmployees() {
        Long totalEmployees = employeeRepository.count();
        return totalEmployees;
    }

//    public Employee createdByFunction(Employee employee) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        employee.setCreatedBy(auth.getName());
//        return employee;
//    }

}
