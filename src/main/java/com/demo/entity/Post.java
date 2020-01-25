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
public class Post {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String title;

	private String content;

	private String status;

	private String tag;
	
	private Date create_ts = new Date();



}