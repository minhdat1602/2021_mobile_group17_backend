package com.nlu.controller.publics;

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
import com.nlu.payload.response.MessageResponse;
import com.nlu.service.Impl.ReviewService;
import com.nlu.payload.response.DataResponse;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/exist")
	public ResponseEntity<?> checkExist(@PathParam(value = "productId") Long productId,
			@PathParam(value = "userId") Long userId) {
		Boolean result = reviewService.existComment(userId, productId);
		MessageResponse response = new MessageResponse();
		response.setStatus("success");
		response.setMessage(result.toString());
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<?> getByProduct(@PathParam(value = "productId") Long productId) {
		List<ReviewDTO> data;
		try {
			data = reviewService.getByProduct(productId);
			DataResponse response = new DataResponse();
			response.setStatus("success");
			response.setData(data);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			MessageResponse response = new MessageResponse();
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
			DataResponse response = new DataResponse();
			response.setStatus("success");
			response.setData(data);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			MessageResponse response = new MessageResponse();
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
			DataResponse response = new DataResponse();
			response.setStatus("success");
			response.setData(data);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			MessageResponse response = new MessageResponse();
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
			DataResponse response = new DataResponse();
			response.setStatus("success");
			response.setData(null);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			MessageResponse response = new MessageResponse();
			response.setStatus("fail");
			response.setMessage(e.getMessage());
			return ResponseEntity.ok(response);
		}
	}

}
