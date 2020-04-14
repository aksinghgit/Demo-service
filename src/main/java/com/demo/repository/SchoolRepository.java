package com.demo.repository;

import com.demo.entity.School;
import java.util.concurrent.Future;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.List;

/**
 * @author amol sharma
 *
 */
@Repository
public interface SchoolRepository extends JpaRepository<School,String>{


  public List<School> findByCountryId(String countryId);

}