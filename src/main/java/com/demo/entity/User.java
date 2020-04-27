package com.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author amritesh
 *
 */
@Entity
@Data
public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@NotNull(message = "User Name is mandatory")
	private String username;

	@NotNull(message = "First Name is mandatory")
	private String fname;
	
	@NotNull(message = "Last Name is mandatory")
	private String lname;

	private String oldPassword;
	
	@NotNull(message = "Passwrod is mandatory")
	private String password;
	
	
	private String secureSalt;
	
	@NotNull(message = "School Id is mandatory")
	private String schoolId;
	
	private Date create_ts = new Date();
	
	private Date updated_ts = new Date();



}