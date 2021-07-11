package com.nlu.controller;

import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.UserDTO;
import com.nlu.dto.UserInfoDTO;
import com.nlu.entity.UserEntity;
import com.nlu.entity.UserInfoEntity;
import com.nlu.payload.request.SignupRequest;
import com.nlu.payload.response.Data;
import com.nlu.payload.response.Message;
import com.nlu.service.UserInfoService;
import com.nlu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(userService.getAll());
	}

	@GetMapping
	public ResponseEntity<?> getById(@PathParam("userid") long userId) {
		return ResponseEntity.ok(userService.getByID(userId));
	}

	public ResponseEntity<?> updateUser(@RequestBody SignupRequest user) {
		UserEntity userEntity = mapper.map(user, UserEntity.class);
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		UserEntity result = userService.save(userEntity);

		try {
			Data response = new Data();
			response.setStatus("success");
			response.setData(mapper.map(result, UserDTO.class));
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			Message response = new Message();
			response.setStatus("fail");
			response.setMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}

	}

	@PutMapping("/userInfo")
	public ResponseEntity<?> updateUserInfo(@RequestBody UserDTO userDTO) {

		UserEntity userEntity = mapper.map(userDTO, UserEntity.class);
		UserInfoEntity userInfoEntity = mapper.map(userDTO.getUserInfo(), UserInfoEntity.class);
		userInfoEntity.setUser(userEntity);

		userInfoEntity = userInfoService.save(userInfoEntity);
		UserInfoDTO result;
		try {
			result = mapper.map(userInfoEntity, UserInfoDTO.class);
			Data response = new Data();
			response.setStatus("success");
			response.setData(result);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			Message response = new Message();
			response.setStatus("fail");
			response.setMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}

}
