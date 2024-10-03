package com.Administration.Pro.Administration.Pro.utils;

import com.Administration.Pro.Administration.Pro.Services.EmployeeService;
import com.Administration.Pro.Administration.Pro.Webdomains.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FormatterUtils {
    public static final String DATE_FORMATTER = "dd-MM-yyyy HH:mm";

    @Autowired
    private static EmployeeService employeeService;


    public static String formatDateTime (LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        String formatDateTime = localDateTime.format(formatter);
        return formatDateTime;
    }

//    public static List<Employee> sortedList = employeeService.getAllEmployees().stream().sorted(Comparator.comparing(Employee::getDob).reversed()).collect(Collectors.toList());
}
