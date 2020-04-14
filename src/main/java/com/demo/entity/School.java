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
public class School {

	@Id
	private String school_id;

	@Column(name = "country_id", nullable = false)
	private String countryId;

	private String state;

	private String school_name;

	private String school_dname;
	
	private Date create_ts = new Date();

	private Date updated_ts = new Date();

}