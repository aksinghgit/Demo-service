package com.demo.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author amol
 *
 */
@Entity
@Data
public class Course {

	@Id
	private String course_id;

	@Column(name = "department_id", nullable = false)
	private String departmentId;

	private String course_name;

	private String course_dname;

	private String course_code;
	
	private Date create_ts = new Date();

	private Date updated_ts = new Date();

}