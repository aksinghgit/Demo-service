package com.demo.controller;

import com.demo.entity.Department;
import com.demo.service.DepartmentService;
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
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/service/department")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		Department savedDepartment = departmentService.saveDepartment(department);
		System.out.println("Department Saved Successfully" + savedDepartment);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
	}

	@GetMapping("/service/departments")
	public List<Department> getCountries() {
		List<Department> departments = departmentService.retrieveDepartments();
		return departments;
	}

	@GetMapping("/service/getdepartmentsbyschoolid/{schoolId}")
	public List<Department> getDepartmentsBySchoolId(@PathVariable(name = "schoolId") String school_Id) {
		List<Department> departments = departmentService.getDepartmentsBySchoolId(school_Id);
		return departments;
	}

	@GetMapping("/service/department/{departmentId}")
	public Department getDepartment(@PathVariable(name = "departmentId") String DepartmentId) {
		return departmentService.getDepartment(DepartmentId);
	}

	@DeleteMapping("/service/department/{departmentId}")
	public boolean deleteEmployee(@PathVariable(name = "departmentId") String departmentId) {
		return departmentService.deleteDepartment(departmentId);
	}

	@PutMapping("/service/department/{departmentId}")
	public Department updateEmployee(@RequestBody Department department, @PathVariable(name = "departmentId") String departmentId) {
		Department savedDepartment = departmentService.getDepartment(departmentId);
		if (savedDepartment != null) {
			department.setDepartment_id(savedDepartment.getDepartment_id());
			savedDepartment = departmentService.updateDepartment(department);
		}
		return savedDepartment;
	}

}