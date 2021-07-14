package com.nlu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.ProductDTO;
import com.nlu.payload.response.Data;
import com.nlu.payload.response.Message;
import com.nlu.service.ProductService;

@RestController("/admin/product")
public class AdminProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	private ResponseEntity<?> fetchAll() {
		List<ProductDTO> products;
		try {
			products = productService.getAlll();
			Data response = new Data();
			response.setStatus("success");
			response.setData(products);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			Message response = new Message();
			response.setStatus("fail");
			response.setMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
}
