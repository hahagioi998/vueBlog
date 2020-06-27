package com.example.shiro;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AccountProfile implements Serializable {
    private Long id;

    private String username;

    private String avatar;

    private String email;

    private String password;

    private Integer status;

    private LocalDateTime created;

    private LocalDateTime lastLogin;

}
