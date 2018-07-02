package com.javamongodb.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private String id;

    private String username;

    private String password;

    private Set<String> roles;
}
