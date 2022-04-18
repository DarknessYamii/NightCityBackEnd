package com.yandc.nightcityportalside.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yandc.nightcityportalside.models.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetailsImpl.
 */
public class UserDetailsImpl implements UserDetails {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private Long id;
	
	/** The username. */
	private String username;
	
	/** The email. */
	private String email;
	
	/** The password. */
	@JsonIgnore
	private String password;
	
	/** The authorities. */
	private Collection<? extends GrantedAuthority> authorities;
	
	/**
	 * Instantiates a new user details impl.
	 *
	 * @param id the id
	 * @param username the username
	 * @param email the email
	 * @param password the password
	 * @param authorities the authorities
	 */
	public UserDetailsImpl(Long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		}
	
	/**
	 * Builds the.
	 *
	 * @param user the user
	 * @return the user details impl
	 */
	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
			.map(role -> new SimpleGrantedAuthority(role.getName().name()))
			.collect(Collectors.toList());
		return new UserDetailsImpl(
			user.getId(),
			user.getUsername(),
			user.getEmail(),
			user.getPassword(),
			authorities);
	}
	
	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	return authorities;
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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
	return email;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
	return password;
	}
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
	return username;
	}
	
	/**
	 * Checks if is account non expired.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
	return true;
	}
	
	/**
	 * Checks if is account non locked.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
	return true;
	}
	
	/**
	 * Checks if is credentials non expired.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
	return true;
	}
	
	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
	return true;
	}
	
	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
	return true;
		if (o == null || getClass() != o.getClass())
	return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
	return Objects.equals(id, user.id);
	}
}
