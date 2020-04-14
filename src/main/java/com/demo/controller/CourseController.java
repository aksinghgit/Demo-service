package com.demo.controller;

import com.demo.entity.Course;
import com.demo.service.CourseService;
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
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping("/service/course")
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		Course savedCourse = courseService.saveCourse(course);
		System.out.println("Course Saved Successfully" + savedCourse);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
	}

	@GetMapping("/service/courses")
	public List<Course> getCountries() {
		List<Course> courses = courseService.retrieveCourses();
		return courses;
	}

	@GetMapping("/service/getcoursesbydepartmentid/{departmentId}")
	public List<Course> getCoursesByDepartmentId(@PathVariable(name = "departmentId") String department_Id) {
		List<Course> courses = courseService.getCoursesByDepartmentId(department_Id);
		return courses;
	}

	@GetMapping("/service/course/{courseId}")
	public Course getCourse(@PathVariable(name = "courseId") String CourseId) {
		return courseService.getCourse(CourseId);
	}

	@DeleteMapping("/service/course/{courseId}")
	public boolean deleteEmployee(@PathVariable(name = "courseId") String courseId) {
		return courseService.deleteCourse(courseId);
	}

	@PutMapping("/service/course/{courseId}")
	public Course updateEmployee(@RequestBody Course course, @PathVariable(name = "courseId") String courseId) {
		Course savedCourse = courseService.getCourse(courseId);
		if (savedCourse != null) {
			course.setCourse_id(savedCourse.getCourse_id());
			savedCourse = courseService.updateCourse(course);
		}
		return savedCourse;
	}

}