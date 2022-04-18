package com.yandc.nightcityportalside.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yandc.nightcityportalside.models.IRole;
import com.yandc.nightcityportalside.models.Role;
import com.yandc.nightcityportalside.models.User;
import com.yandc.nightcityportalside.payload.request.JwtResponse;
import com.yandc.nightcityportalside.payload.request.LoginRequest;
import com.yandc.nightcityportalside.payload.request.MessageResponse;
import com.yandc.nightcityportalside.payload.request.SignupRequest;
import com.yandc.nightcityportalside.repository.RoleRepository;
import com.yandc.nightcityportalside.repository.UserRepository;
import com.yandc.nightcityportalside.security.UserDetailsImpl;
import com.yandc.nightcityportalside.security.JWT.JWTUtils;
/**
 * The Class AuthController.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	/** The authentication manager. */
	@Autowired
	AuthenticationManager authenticationManager;

	/** The user repository. */
	@Autowired
	UserRepository userRepository;

	/** The role repository. */
	@Autowired
	RoleRepository roleRepository;

	/** The encoder. */
	@Autowired
	PasswordEncoder encoder;

	/** The jwt utils. */
	@Autowired
	JWTUtils jwtUtils;

	/**
	 * Authenticate user.
	 *
	 * @param loginRequest the login request
	 * @return the response entity
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	/**
	 * Register user.
	 *
	 * @param signUpRequest the sign up request
	 * @return the response entity
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username existente!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email existente!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(IRole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role no encontrado."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(IRole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role no encontrado."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(IRole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role no encontrado."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(IRole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role no encontrado."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
