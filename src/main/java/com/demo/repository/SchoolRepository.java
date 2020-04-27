package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.School;

/**
 * @author amol sharma
 *
 */
@Repository
public interface SchoolRepository extends JpaRepository<School,String>{


  public List<School> findByCountryId(String countryId);

}