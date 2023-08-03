package com.restfull.demo.restservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class EmployeeController {
	
	@GetMapping("/employee")
	public Employee getEmployee() {
		return new Employee("Punta", "Dewa", "puntadewa", "P@ssw0rd");
	}
	
	@GetMapping("/employee2")
	public MappingJacksonValue getEmployee2() {
		
		Employee2 employee2 = new Employee2("Punta", "Dewa", "puntadewa", "P@ssw0rd");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employee2);
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName");
		
		FilterProvider filter = new SimpleFilterProvider().addFilter("employee2Filter", simpleBeanPropertyFilter);
		mappingJacksonValue.setFilters(filter);
		
		return mappingJacksonValue;
	}
}
