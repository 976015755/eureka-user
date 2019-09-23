package com.gift.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "g_user")
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(columnDefinition = "INT(10) NOT NULL", name = "u_id")
	private Integer id; 
	
	@Column(columnDefinition = "varchar(255) NOT NULL DEFAULT ''", name = "u_username")
	private String username;
	
	@Column(columnDefinition = "varchar(255) NOT NULL DEFAULT ''", name = "u_password")
	private String password;
	
	@Column(columnDefinition = "bit DEFAULT 0", name = "u_level")
	private Integer level;
}
