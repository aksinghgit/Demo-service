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
public class Department {

	@Id
	private String department_id;

	@Column(name = "school_id", nullable = false)
	private String schoolId;

	private String department_name;

	private String department_dname;

	private String department_code;
	
	private Date create_ts = new Date();

	private Date updated_ts = new Date();

}