package com.yandc.nightcityportalside.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yandc.nightcityportalside.models.User;
import com.yandc.nightcityportalside.repository.UserRepository;



/**
 * The Class UserDetailsServiceImpl.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	/** The user repository. */
	@Autowired
	UserRepository userRepository;
	
	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRepository.findByUsername(username)
	.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con username: " + username));
	return UserDetailsImpl.build(user);
	}
	
}