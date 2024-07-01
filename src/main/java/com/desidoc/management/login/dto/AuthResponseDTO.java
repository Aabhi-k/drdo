package com.desidoc.management.login.dto;
public class AuthResponseDTO {

	private String accessToken;
	private String username;
	private static final long serialVersionUID = -8091879091924046844L;

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
