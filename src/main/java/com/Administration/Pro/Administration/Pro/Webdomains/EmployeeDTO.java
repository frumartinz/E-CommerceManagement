package com.Administration.Pro.Administration.Pro.Webdomains;

import lombok.Data;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

@Data
public class EmployeeDTO {
    private long id;
    private String surname;
    private String givenName;
    private String email;
    private String address;
    private String yoe;
    private String pob;
    private String dob;
    private String hq;
    private long number;
    private String nationality;
    private String department;
    private String sex;
    private String imageName;
}
