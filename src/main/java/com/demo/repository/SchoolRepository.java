package com.demo.repository;

import com.demo.entity.Country;
import com.demo.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author amol sharma
 *
 */
@Repository
public interface SchoolRepository extends JpaRepository<School,String>{

}