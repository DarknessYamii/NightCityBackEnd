package com.yandc.nightcityportalside.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Class Role.
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue
	(strategy= GenerationType.IDENTITY)
	private Long idRole;
	
	@Column(unique = true, length=20)
	private String rolName;
	
	@ManyToMany(mappedBy="roles")
	private List<Users> user;

	/**
	 * @return the user
	 */
	public List<Users> getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(List<Users> user) {
		this.user = user;
	}

	/**
	 * @return the idRole
	 */
	public Long getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole the idRole to set
	 */
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	/**
	 * @return the rolName
	 */
	public String getRolName() {
		return rolName;
	}

	/**
	 * @param rolName the rolName to set
	 */
	public void setRolName(String rolName) {
		this.rolName = rolName;
	}
}
	
