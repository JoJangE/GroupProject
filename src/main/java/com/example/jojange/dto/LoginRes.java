package com.example.jojange.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRes {
    private boolean access;

    private String message;

    private String accessToken;

    private String refreshToken;

    public LoginRes(boolean access, String message) {
        this.access = access;
        this.message = message;
    }

    public LoginRes(boolean access, String message, String accessToken, String refreshToken) {
        this.access = access;
        this.message = message;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
