package com.demo.service;

import com.demo.entity.Country;
import com.demo.entity.Post;
import java.util.List;


/**
 * @author amol
 *
 */
public interface CountryService {
 public List<Country> retrieveCountries();
 
 public Country getCountry(String country_id);
 
 public Country saveCountry(Country country);
 
 public boolean deleteCountry(String country_id);
 
 public Country updateCountry(Country country);
}