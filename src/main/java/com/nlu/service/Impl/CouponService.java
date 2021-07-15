package com.nlu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.CouponEntity;
import com.nlu.repository.CouponRepository;

@Service
public class CouponService {

	@Autowired
	private CouponRepository couponRepository;

	public List<CouponEntity> getAll() {
		List<CouponEntity> coupon = couponRepository.findAll();
		return coupon;
	}

	public CouponEntity getById(long id) {
		CouponEntity coupon = couponRepository.findById(id);
		return coupon;
	}

	public CouponEntity insert(CouponEntity couponEntity) {
		CouponEntity coupon = couponRepository.save(couponEntity);
		return coupon;
	}

	public CouponEntity update(CouponEntity couponEntity) {
		CouponEntity coupon = couponRepository.save(couponEntity);
		return coupon;
	}

	public void delete(long id) {
		couponRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			couponRepository.deleteById(id);
	}
}
