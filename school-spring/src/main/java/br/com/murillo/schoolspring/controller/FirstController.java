package br.com.murillo.schoolspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@GetMapping (path = "/ola")
	// @RequestMapping(method = RequestMethod.GET, path = "/ola")
	public String ola() {
		return "Ola Spring Boot!";
	}
}
