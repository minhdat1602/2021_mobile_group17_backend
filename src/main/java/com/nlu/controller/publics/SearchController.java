//package com.nlu.controller.publics;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.nlu.dto.ProductDTO;
//import com.nlu.service.Impl.ProductServiceImpl;
//
//@RestController
//public class SearchController {
//
//	private final ProductServiceImpl productService;
//
//	@Autowired
//	public SearchController(ProductServiceImpl productService) {
//		this.productService = productService;
//	}
//
//	@GetMapping("/search")
//	public ResponseEntity<?> searchByKeyword(@RequestParam String keyword) {
//		List<ProductDTO> result = productService.findByKeyword(keyword);
//		return ResponseEntity.ok(result);
//	}
//}
