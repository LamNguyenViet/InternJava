package com.tamdongtam.java;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employe {
	@RequestMapping(value="/index")
	public String myname() {
		return "Tên tôi là thủy";
	}
}
