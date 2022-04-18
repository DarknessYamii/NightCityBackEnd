package com.yandc.nightcityportalside.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Role.
 */
@Entity @Table(name = "roles")
public class Role {
	
	/** The id. */
	@Id
	@GeneratedValue
	(strategy= GenerationType.IDENTITY)
	
	private Integer id;
	
	/** The name. */
	@Enumerated
	(EnumType.STRING)
	@Column
	(length= 20, name="NAME")
	private IRole name;
	
		/**
		 * Instantiates a new role.
		 */
		public Role() {
		}
		
		/**
		 * Instantiates a new role.
		 *
		 * @param name the name
		 */
		public Role (IRole name) {
		this.name = name;
		}
		
		/**
		 * Gets the id.
		 *
		 * @return the id
		 */
		public Integer getId() {
		return id;
		}
		
		/**
		 * Sets the id.
		 *
		 * @param id the new id
		 */
		public void setId (Integer id) {
			this.id = id;
		}
		
		/**
		 * Gets the name.
		 *
		 * @return the name
		 */
		public IRole getName() {
		return name;
		}
		
		/**
		 * Sets the name.
		 *
		 * @param name the new name
		 */
		public void setName(IRole name) {
		this.name= name;
		}
}