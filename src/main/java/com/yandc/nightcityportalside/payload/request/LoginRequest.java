package com.yandc.nightcityportalside.payload.request;


import javax.validation.constraints.NotBlank;

/**
 * The Class LoginRequest.
 */
public class LoginRequest {
	
	/** The username. */
	@NotBlank
	private String username;
	
	/** The password. */
	@NotBlank
	private String password;
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
	return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
	this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
	return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
	this.password = password;
	}
}