package com.restfull.demo.restservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@GetMapping("/v1/person")
	public Person getFirstPerson() {
		return new Person("Bob Charly");
	}
	
	@GetMapping("/v2/person")
	public Person getSecondPerson() {
		return new Person("Bob Charly 2");
	}
}
