package com.demo.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author amol
 *
 */
@Entity
@Data
public class School {

	@Id
	private String school_id;

	private String school_name;

	private String school_dname;
	
	private Date create_ts = new Date();

	private Date updated_ts = new Date();

}