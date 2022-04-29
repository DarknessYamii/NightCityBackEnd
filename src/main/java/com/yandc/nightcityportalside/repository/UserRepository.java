package com.yandc.nightcityportalside.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yandc.nightcityportalside.models.Users;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the optional
	 */
	public Users findByUsername(String username);
	
	/**
	 * Exists by username.
	 *
	 * @param username the username
	 * @return the boolean
	 */
	Boolean existsByUsername(String username);
	
	/**
	 * Exists by email.
	 *
	 * @param email the email
	 * @return the boolean
	 */
	Boolean existsByEmail(String email);

	public Users findByIdUser(Long idUser);
}
