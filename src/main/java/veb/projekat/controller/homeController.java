package veb.projekat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController{

	@GetMapping("/")
	public String welcome() {
		return "Login.html";
	}
	
	
	@GetMapping("/admin")
	public String admin() {
		return "Administrator.html";
	}

}
