package com.nlu.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.ReviewDTO;
import com.nlu.payload.response.Fail;
import com.nlu.payload.response.Success;
import com.nlu.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public ResponseEntity<?> getByProduct(@PathParam(value = "productId") Long productId) {
		List<ReviewDTO> data;
		try {
			data = reviewService.getByProduct(productId);
			Success response = new Success();
			response.setStatus("success");
			response.setData(data);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			Fail response = new Fail();
			response.setStatus("500");
			response.setMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}

	@PostMapping
	public ResponseEntity<?> insertReview(@RequestBody ReviewDTO reviewDTO) {
		ReviewDTO data;
		try {
			data = reviewService.save(reviewDTO);
			Success response = new Success();
			response.setStatus("success");
			response.setData(data);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			Fail response = new Fail();
			response.setStatus("fail");
			response.setMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}

	@PutMapping
	public ResponseEntity<?> updateReview(@RequestBody ReviewDTO reviewDTO) {
		ReviewDTO data;
		try {
			data = reviewService.save(reviewDTO);
			Success response = new Success();
			response.setStatus("success");
			response.setData(data);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			Fail response = new Fail();
			response.setStatus("fail");
			response.setMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deleteReview(@RequestBody ReviewDTO reviewDTO) {
//		ReviewDTO data;
		try {
			reviewService.delete(reviewDTO.getId());
			Success response = new Success();
			response.setStatus("success");
			response.setData(null);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			Fail response = new Fail();
			response.setStatus("fail");
			response.setMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}

}
