package com.yandc.nightcityportalside.service;



import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yandc.nightcityportalside.models.Role;
import com.yandc.nightcityportalside.models.Users;
import com.yandc.nightcityportalside.repository.RoleRepository;
import com.yandc.nightcityportalside.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username);
		saveUserWithDefaultRole(user);
		if(user == null ) {
			logger.error("ERROR en el Login: no existe el usuario '"+username+"' en el sistema!");
			throw new UsernameNotFoundException("ERROR en el Login: no existe el usuario '"+username+"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRolName()))
				.peek(authority -> logger.info("Role: "+ authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
	
	public void saveUserWithDefaultRole(Users user) {
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		String encodedPassword = enconder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		Role roleUser = roleRepository.findByRolName("ROLE_USER");
		user.addRoles(roleUser);
		user.setEnabled(true);
		
		userRepository.save(user);
	}

}
