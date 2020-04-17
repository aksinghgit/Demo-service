package com.demo.service;

import com.demo.entity.Country;
import com.demo.entity.School;
import java.util.List;


/**
 * @author amol
 *
 */
public interface SchoolService {
 public List<School> retrieveSchools();
 
 public School getSchool(String school_id);
 
 public School saveSchool(School school);
 
 public boolean deleteSchool(String school_id);
 
 public School updateSchool(School school);

 public List<School> getSchoolsByCountryId(String country_id);
}