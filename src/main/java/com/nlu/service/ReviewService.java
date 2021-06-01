package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.ReviewEntity;
import com.nlu.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

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

	public void delete(long id) {
		reviewRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			reviewRepository.deleteById(id);
	}
}
