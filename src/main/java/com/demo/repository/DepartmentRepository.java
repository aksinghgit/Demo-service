package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Department;

/**
 * @author amol sharma
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department,String>{


  public List<Department> findBySchoolId(String schoolId);

}