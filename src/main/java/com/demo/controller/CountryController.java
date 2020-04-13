package com.demo.controller;

import com.demo.entity.Country;
import com.demo.service.CountryService;
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
public class CountryController {

	@Autowired
	private CountryService countryService;

	@PostMapping("/service/country")
	public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
		Country savedCountry = countryService.saveCountry(country);
		System.out.println("Country Saved Successfully" + savedCountry);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
	}

	@GetMapping("/service/countries")
	public List<Country> getCountries() {
		List<Country> countries = countryService.retrieveCountries();
		return countries;
	}

	@GetMapping("/service/country/{countryId}")
	public Country getCountry(@PathVariable(name = "countryId") String CountryId) {
		return countryService.getCountry(CountryId);
	}

	@DeleteMapping("/service/country/{countryId}")
	public boolean deleteEmployee(@PathVariable(name = "countryId") String countryId) {
		return countryService.deleteCountry(countryId);
	}

	@PutMapping("/service/country/{countryId}")
	public Country updateEmployee(@RequestBody Country country, @PathVariable(name = "countryId") String countryId) {
		Country savedCountry = countryService.getCountry(countryId);
		if (savedCountry != null) {
			country.setCountry_id(savedCountry.getCountry_id());
			savedCountry = countryService.updateCountry(country);
		}
		return savedCountry;
	}

}