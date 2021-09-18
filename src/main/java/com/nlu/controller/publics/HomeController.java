package com.nlu.controller.publics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.service.Impl.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/hot")
	public ResponseEntity<?> fetchByIsHot(){
		return ResponseEntity.ok(homeService.findByIsHot());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/highlight")
	public ResponseEntity<?> fetchByIsHighLight(){
		return ResponseEntity.ok(homeService.findByIsHighLight());
	}
}
