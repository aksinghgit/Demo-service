package com.demo.service.impl;

import com.demo.entity.Country;
import com.demo.repository.CountryRepository;
import com.demo.service.CountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author amol
 *
 */
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<Country> retrieveCountries() {
		List<Country> allCountry = countryRepository.findAll();
		return allCountry;
	}

	@Override
	public Country getCountry(String country_id) {
		return countryRepository.findById(country_id).get();
	}

	@Override
	public Country saveCountry(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public boolean deleteCountry(String country_Id) {
		boolean result = true;
		try {
			countryRepository.deleteById(country_Id);

		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public Country updateCountry(Country country) {
		return countryRepository.save(country);
	}
}