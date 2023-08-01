package com.restfull.demo.restservices.hello;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private MessageSource messageSource;
	
	public HelloController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String hello() {
		return "Hello!!";
	}
	
	@GetMapping(path = "/helloYou")
	public String helloYou() {
		return "Hello You!!";
	}
	
	@GetMapping(path = "/helloBean")
	public HelloBean helloBean() {
		return new HelloBean("Hello Bean!!");
	}
	
	@GetMapping(path = "/helloInternationalization")
	public String helloInternationalization() {
		Locale locale =LocaleContextHolder.getLocale();
		return messageSource.getMessage("msg.greating.goodmorning", null, "Defaulte Message", locale);
		
	}
}
