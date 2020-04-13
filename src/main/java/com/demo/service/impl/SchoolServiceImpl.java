package com.demo.service.impl;

import com.demo.entity.School;
import com.demo.repository.SchoolRepository;
import com.demo.service.SchoolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author amol
 *
 */
@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public List<School> retrieveSchools() {
		List<School> allSchool = schoolRepository.findAll();
		return allSchool;
	}

	@Override
	public School getSchool(String school_id) {
		return schoolRepository.findById(school_id).get();
	}

	@Override
	public School saveSchool(School school) {
		return schoolRepository.save(school);
	}

	@Override
	public boolean deleteSchool(String school_Id) {
		boolean result = true;
		try {
			schoolRepository.deleteById(school_Id);

		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public School updateSchool(School school) {
		return schoolRepository.save(school);
	}
}