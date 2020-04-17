package com.demo.repository;

import com.demo.entity.Department;
import com.demo.entity.School;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author amol sharma
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department,String>{


  public List<Department> findBySchoolId(String schoolId);

}