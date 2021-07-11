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
import com.nlu.payload.response.Message;
import com.nlu.repository.RoleRepository;
import com.nlu.repository.UserInfoRepository;
import com.nlu.repository.UserRepository;
import com.nlu.security.jwt.JwtUtils;
import com.nlu.security.services.UserDetailsImpl;

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
			Message message = new Message();
			message.setStatus("fail");
			message.setStatus("Email is already in use!");
			return ResponseEntity.ok(message);
		}

		// Create new user's account
		UserEntity user = new UserEntity(signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

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
		// Tạo mới user với email, password và roles;
		userRepository.save(user);

		// Tạo mới thông của của user;
		UserInfoEntity userInfoEntity = new UserInfoEntity();
		if (userInfoEntity != null) {
			userInfoEntity = modelMapper.map(signUpRequest.getUserInfo(), UserInfoEntity.class);
			userInfoEntity.setUser(user);
			userInfoRepository.save(userInfoEntity);
		}

		Message response = new Message();
		response.setStatus("success");
		response.setMessage("User registered successfully!");

		return ResponseEntity.ok(response);
	}
}