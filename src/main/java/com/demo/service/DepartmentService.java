package com.demo.service;

import com.demo.entity.Department;
import java.util.List;


/**
 * @author amol
 *
 */
public interface DepartmentService {
 public List<Department> retrieveDepartments();
 
 public Department getDepartment(String department_id);
 
 public Department saveDepartment(Department department);
 
 public boolean deleteDepartment(String department_id);
 
 public Department updateDepartment(Department department);

 public List<Department> getDepartmentsBySchoolId(String school_id);
}