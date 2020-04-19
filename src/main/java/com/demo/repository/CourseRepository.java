package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Course;

/**
 * @author amol sharma
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course,String>{


  public List<Course> findByDepartmentId(String departmentId);

}