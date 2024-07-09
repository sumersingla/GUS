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

    public User(String name, String email, Long id, String password, LocalDateTime lastLogin) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.password = password;
        this.lastLogin = lastLogin;
    }
}
