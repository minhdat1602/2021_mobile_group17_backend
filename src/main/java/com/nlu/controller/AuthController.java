package com.nlu.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.common.ERole;
import com.nlu.dto.UserInfoDTO;
import com.nlu.entity.RoleEntity;
import com.nlu.entity.UserEntity;
import com.nlu.entity.UserInfoEntity;
import com.nlu.payload.request.LoginRequest;
import com.nlu.payload.request.SignupRequest;
import com.nlu.payload.response.JwtResponse;
import com.nlu.payload.response.MessageResponse;
import com.nlu.repository.RoleRepository;
import com.nlu.repository.UserInfoRepository;
import com.nlu.repository.UserRepository;
import com.nlu.security.jwt.JwtUtils;
import com.nlu.security.services.UserDetailsImpl;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		UserInfoEntity userInfo = userInfoRepository.findByUserId(userDetails.getId());
		if (userInfo == null)
			System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
		else
			System.out.println(userInfo.getId());
		JwtResponse response = new JwtResponse();
		response.setEmail(userDetails.getUsername());
		response.setAccessToken(jwt);
		response.setType("Bearer");
		response.setUserInfo(modelMapper.map(userInfo, UserInfoDTO.class));
		response.setId(userDetails.getId());
		response.setRoles(roles);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}
		

		// Create new user's account
		UserEntity user = new UserEntity(signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
		UserInfoEntity userInfoEntity = new UserInfoEntity();
		userInfoEntity = modelMapper.map(signUpRequest.getUserInfo(), UserInfoEntity.class);
//		userInfoEntity.setFirstName(signUpRequest.getFirstName());
//		userInfoEntity.setLastName(signUpRequest.getLastName());
//		userInfoEntity.setPhone(signUpRequest.getPhone());	
//		userInfoEntity.setXa(signUpRequest.getXa());
//		userInfoEntity.setHuyen(signUpRequest.getHuyen());
//		userInfoEntity.setTinh(signUpRequest.getTinh());
		userInfoEntity.setUser(user);
		System.out.println(signUpRequest.getUserInfo().getFirstName());

//		user.setFirstName(signUpRequest.getFirstName());
//		user.setLastName(signUpRequest.getLastName());
//		user.setPhone(signUpRequest.getPhone());
//		user.setAddress(signUpRequest.getAddress());

		Set<String> strRoles = signUpRequest.getRole();
		Set<RoleEntity> roles = new HashSet<>();

		if (strRoles == null) {
			RoleEntity userRole = roleRepository.findByCode(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					RoleEntity adminRole = roleRepository.findByCode(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					RoleEntity modRole = roleRepository.findByCode(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					RoleEntity userRole = roleRepository.findByCode(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		userInfoRepository.save(userInfoEntity);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}