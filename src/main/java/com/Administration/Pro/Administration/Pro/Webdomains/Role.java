package com.Administration.Pro.Administration.Pro.Webdomains;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Column (nullable = false, unique = true)
    private String name ;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
