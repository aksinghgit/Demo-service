package com.demo.service.impl;

import com.demo.entity.Course;
import com.demo.repository.CourseRepository;
import com.demo.service.CourseService;
import com.demo.service.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author amol
 *
 */
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> retrieveCourses() {
		List<Course> allCourse = courseRepository.findAll();
		return allCourse;
	}

	@Override
	public Course getCourse(String course_id) {
		return courseRepository.findById(course_id).get();
	}

	@Override
	public List<Course> getCoursesByDepartmentId(String department_id) {
		return courseRepository.findByDepartmentId(department_id);
	}

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public boolean deleteCourse(String course_Id) {
		boolean result = true;
		try {
			courseRepository.deleteById(course_Id);

		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}
}