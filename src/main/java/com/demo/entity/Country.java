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
public class Country {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String country_id;

	private String name;

	private String abv3;

	private String abv3_alt;

	private Integer code;

	private String slug;
	
	private Date create_ts = new Date();

	private Date updated_ts = new Date();

}