package com.Administration.Pro.Administration.Pro.Webdomains;

import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeDTO {
    private Long id;
    private String surname;
    private String givenName;
    private String email;
    private String address;
    private String yoe;
    private String pob;
    private Date dob;
    private String hq;
    private Long number;
    private String nationality;
    private String department;
    private String sex;
    private String imageName;
}
