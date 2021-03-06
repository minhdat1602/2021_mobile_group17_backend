package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.ReviewEntity;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
	List<ReviewEntity> findAll();

	ReviewEntity findById(long id);

	List<ReviewEntity> findByProductId(Long productId);

	<S extends ReviewEntity> S save(S entity);

	void delete(ReviewEntity reviewEntity);

	void deleteById(Long id);

	boolean existsById(Long id);
	
	Boolean existsByUserIdAndProductId(Long userId, Long productId);
}
