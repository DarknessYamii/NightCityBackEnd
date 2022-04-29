package com.yandc.nightcityportalside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yandc.nightcityportalside.models.Role;

/**
 * The Interface RoleRepository.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the optional
	 */
	public Role findByRolName(Role name);
}
