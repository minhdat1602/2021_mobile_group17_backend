package com.nlu.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.ReviewDTO;
import com.nlu.entity.ReviewEntity;
import com.nlu.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ModelMapper mapper;

	public List<ReviewDTO> getByProduct(Long productId) {
		List<ReviewEntity> reviewEntitys = reviewRepository.findByProductId(productId);
		List<ReviewDTO> results = new ArrayList<ReviewDTO>();
		for (ReviewEntity reviewEntity : reviewEntitys) {
			results.add(mapper.map(reviewEntity, ReviewDTO.class));
		}
		return results;
	}

	public ReviewDTO save(ReviewDTO reviewDTO) {
		ReviewEntity reviewEntity = new ReviewEntity();
		if (reviewDTO.getId() != null) {
			ReviewEntity oldReviewEntity = reviewRepository.findById(reviewDTO.getId().longValue());
			oldReviewEntity = mapper.map(reviewDTO, ReviewEntity.class);
			reviewEntity = oldReviewEntity;
		} else {
			reviewEntity = mapper.map(reviewDTO, ReviewEntity.class);
		}

		reviewEntity = reviewRepository.save(reviewEntity);

		return mapper.map(reviewEntity, ReviewDTO.class);
	}

	public List<ReviewEntity> getAll() {
		List<ReviewEntity> reviews = reviewRepository.findAll();
		return reviews;
	}

	public ReviewEntity getById(long id) {
		ReviewEntity review = reviewRepository.findById(id);
		return review;
	}

	public ReviewEntity insert(ReviewEntity reviewEntity) {
		ReviewEntity review = reviewRepository.save(reviewEntity);
		return review;
	}

	public ReviewEntity update(ReviewEntity reviewEntity) {
		ReviewEntity review = reviewRepository.save(reviewEntity);
		return review;
	}

	public void delete(Long id) {
		reviewRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			reviewRepository.deleteById(id);
	}
}
