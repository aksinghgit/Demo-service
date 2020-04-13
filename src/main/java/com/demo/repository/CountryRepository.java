package com.demo.repository;

import com.demo.entity.Country;
import com.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author amol
 *
 */
@Repository
public interface CountryRepository extends JpaRepository<Country,String>{

}