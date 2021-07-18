package com.nlu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.ProductDTO;
import com.nlu.payload.response.DataResponse;
import com.nlu.payload.response.MessageResponse;
import com.nlu.service.ProductService;

@RestController()
@RequestMapping("/admin/product")
public class AdminProductController {

	private final ProductService productService;

	@Autowired
	public AdminProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	private ResponseEntity<?> fetchAll() {
		List<ProductDTO> products = productService.adminGetAll();
		return ResponseEntity.ok(products);
//		try {
//			products = productService.adminGetAll();
//			DataResponse response = new DataResponse();
//			response.setStatus("success");
//			response.setData(products);
//			return ResponseEntity.ok(response);
//		} catch (Exception e) {
//			MessageResponse response = new MessageResponse();
//			response.setStatus("fail");
//			response.setMessage(e.getMessage());
//			return ResponseEntity.badRequest().body(response);
//		}
	}
}
