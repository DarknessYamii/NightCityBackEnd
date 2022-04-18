package com.yandc.nightcityportalside.payload.request;

import java.util.List;


/**
 * The Class JwtResponse.
 */
public class JwtResponse {
	
	/** The token. */
	private String token;
	
	/** The type. */
	private String type = "Bearer";
	
	/** The id. */
	private Long id;
	
	/** The username. */
	private String username;
	
	/** The email. */
	private String email;
	
	/** The roles. */
	private List<String> roles;
	
	/**
	 * Instantiates a new jwt response.
	 *
	 * @param accessToken the access token
	 * @param id the id
	 * @param username the username
	 * @param email the email
	 * @param roles the roles
	 */
	public JwtResponse(String accessToken, Long id, String username, String email,
	List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
	
	/**
	 * Gets the access token.
	 *
	 * @return the access token
	 */
	public String getAccessToken() {
		return token;
	}
	
	/**
	 * Sets the access token.
	 *
	 * @param accessToken the new access token
	 */
	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}
	
	/**
	 * Gets the token type.
	 *
	 * @return the token type
	 */
	public String getTokenType() {
		return type;
	}
	
	/**
	 * Sets the token type.
	 *
	 * @param tokenType the new token type
	 */
	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}
	
}