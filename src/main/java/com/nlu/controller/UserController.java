package com.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.UserDTO;
import com.nlu.dto.UserInfoDTO;
import com.nlu.service.UserInfoService;
import com.nlu.service.UserService;

@RestController
@RequestMapping()
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserInfoService userInfoService;

//	@GetMapping("/all")
//	public ResponseEntity<?> getAll() {
//		return ResponseEntity.ok(userService.getAll());
//	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") long userId) {
		return ResponseEntity.ok(userService.getByID(userId));
	}
	
	@PutMapping("/user")
	public ResponseEntity<?>  updateUser(@RequestBody UserDTO userDTO){
		UserDTO result = userService.save(userDTO);
		return ResponseEntity.ok(result);
		
	}
	
	@PutMapping("/user/userInfo")
	public ResponseEntity<?>  updateUserInfo(@RequestBody UserInfoDTO userInfoDTO){
		UserInfoDTO result = userInfoService.save(userInfoDTO);
		return ResponseEntity.ok(result);
		
	}
	
	
}
