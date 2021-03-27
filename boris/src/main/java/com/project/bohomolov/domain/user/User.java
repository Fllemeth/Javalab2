package com.project.bohomolov.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private LocalDate bdate;
    private Set<Role> roles;

    public User(String name, String surname, String email, String phone, String password, LocalDate bdate, Set<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.bdate = bdate;
        this.roles = roles;
    }
}
