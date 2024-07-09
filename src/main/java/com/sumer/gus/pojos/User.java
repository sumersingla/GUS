package com.sumer.gus.pojos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime lastLogin;

    public User() {
    }

    public User(Long id, String name, String email, String password, LocalDateTime lastLogin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.lastLogin = lastLogin;
    }
}
