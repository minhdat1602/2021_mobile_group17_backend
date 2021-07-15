package com.nlu.controller.publics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.StatusDTO;
import com.nlu.service.Impl.StatusService;

@RestController
@RequestMapping("/status")
public class OrderStatusController {

	@Autowired
	private StatusService statusService;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<StatusDTO> results = statusService.getAll();
		return ResponseEntity.ok(results);
	}
}
