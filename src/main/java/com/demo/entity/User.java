package com.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

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

	private String username;

	private String fname;

	private String lname;

	private String password;
	
	private String schoolId;
	
	private Date create_ts = new Date();
	
	private Date updated_ts = new Date();



}