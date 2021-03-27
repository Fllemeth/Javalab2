package com.project.bohomolov.domain.user;

import lombok.Data;

import java.util.Set;

//extend GrantedAuthority
@Data
public class Role {

    private String id;
    private Set<Privilege> privileges;
}
