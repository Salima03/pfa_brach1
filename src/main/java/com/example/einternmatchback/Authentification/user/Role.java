package com.example.einternmatchback.Authentification.user;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    STUDENT,
    USER,
    MANAGER,
    ADMIN;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
    public static Role fromString(String value) {
        try {
            return Role.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid user type: " + value);
        }
    }

}