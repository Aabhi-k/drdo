package com.desidoc.management.login.dto;

public class AuthResponseDTO {

	private String accessToken;
	private static final long serialVersionUID = -8091879091924046844L;

	public AuthResponseDTO(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

}
