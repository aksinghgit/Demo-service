package com.demo.repository;

import com.demo.entity.Course;
import com.demo.entity.Department;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author amol sharma
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course,String>{


  public List<Course> findByDepartmentId(String departmentId);

}