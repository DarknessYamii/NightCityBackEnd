package com.yandc.nightcityportalside.payload.request;

import java.util.Set;
import javax.validation.constraints.*;

/**
 * The Class SignupRequest.
 */
public class SignupRequest {
	
	/** The username. */
	@NotBlank
	@Size(min = 3, max = 20)
	private String username;
	
	/** The email. */
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	/** The role. */
	private Set<String> role;
	
	/** The password. */
	@NotBlank
	@Size(min = 6, max = 40)
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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
	return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
	this.email = email;
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
	
	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Set<String> getRole() {
	return this.role;
	}
	
	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Set<String> role) {
	this.role = role;
	}
}