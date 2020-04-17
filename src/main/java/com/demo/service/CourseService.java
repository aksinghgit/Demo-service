package com.demo.service;

import com.demo.entity.Course;
import java.util.List;


/**
 * @author amol
 *
 */
public interface CourseService {
 public List<Course> retrieveCourses();
 
 public Course getCourse(String course_id);
 
 public Course saveCourse(Course course);
 
 public boolean deleteCourse(String course_id);
 
 public Course updateCourse(Course course);

 public List<Course> getCoursesByDepartmentId(String department_id);
}