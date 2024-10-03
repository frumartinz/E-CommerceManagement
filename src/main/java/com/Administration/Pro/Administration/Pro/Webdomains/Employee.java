package com.Administration.Pro.Administration.Pro.Webdomains;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

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
//    @Column(nullable = false)
//    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdDate;

    @PrePersist
    private void onCreate() {
        createdDate = new Date();
    }

//    @ManyToOne
//    @JoinColumn(name = "created_by_id")
//    @CreatedBy
//    private User createdBy;


    private String sex;
    private String imageName;

}
