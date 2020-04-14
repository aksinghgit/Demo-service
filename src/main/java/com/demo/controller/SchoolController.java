package com.demo.controller;

import com.demo.entity.School;
import com.demo.service.SchoolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amol
 *
 */
@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@PostMapping("/service/school")
	public ResponseEntity<School> saveSchool(@RequestBody School school) {
		School savedSchool = schoolService.saveSchool(school);
		System.out.println("School Saved Successfully" + savedSchool);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedSchool);
	}

	@GetMapping("/service/schools")
	public List<School> getCountries() {
		List<School> schools = schoolService.retrieveSchools();
		return schools;
	}

	@GetMapping("/service/getschoolsbycountryid/{countryId}")
	public List<School> getSchoolsByCountryId(@PathVariable(name = "countryId") String country_Id) {
		List<School> schools = schoolService.getSchoolsByCountryId(country_Id);
		return schools;
	}

	@GetMapping("/service/school/{schoolId}")
	public School getSchool(@PathVariable(name = "schoolId") String SchoolId) {
		return schoolService.getSchool(SchoolId);
	}

	@DeleteMapping("/service/school/{schoolId}")
	public boolean deleteEmployee(@PathVariable(name = "schoolId") String schoolId) {
		return schoolService.deleteSchool(schoolId);
	}

	@PutMapping("/service/school/{schoolId}")
	public School updateEmployee(@RequestBody School school, @PathVariable(name = "schoolId") String schoolId) {
		School savedSchool = schoolService.getSchool(schoolId);
		if (savedSchool != null) {
			school.setSchool_id(savedSchool.getSchool_id());
			savedSchool = schoolService.updateSchool(school);
		}
		return savedSchool;
	}

}