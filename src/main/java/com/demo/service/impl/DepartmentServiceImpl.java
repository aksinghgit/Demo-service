package com.demo.service.impl;

import com.demo.entity.Department;
import com.demo.repository.DepartmentRepository;
import com.demo.service.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author amol
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Department> retrieveDepartments() {
		List<Department> allDepartment = departmentRepository.findAll();
		return allDepartment;
	}

	@Override
	public Department getDepartment(String department_id) {
		return departmentRepository.findById(department_id).get();
	}

	@Override
	public List<Department> getDepartmentsBySchoolId(String school_id) {
		return departmentRepository.findBySchoolId(school_id);
	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public boolean deleteDepartment(String department_Id) {
		boolean result = true;
		try {
			departmentRepository.deleteById(department_Id);

		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}
}