package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.CouponEntity;

@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
	List<CouponEntity> findAll();

	CouponEntity findById(long id);

	<S extends CouponEntity> S save(S entity);

	void delete(CouponEntity couponEntity);

	void deleteById(Long id);


	boolean existsById(Long id);
}
