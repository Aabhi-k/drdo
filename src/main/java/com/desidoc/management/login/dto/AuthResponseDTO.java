package com.desidoc.management.login.dto;

public class AuthResponseDTO {

    private static final long serialVersionUID = -8091879091924046844L;
    private String accessToken;
    private String username;

    public AuthResponseDTO(String accessToken, String username) {
        this.accessToken = accessToken;
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUsername() {
        return username;
    }
}
