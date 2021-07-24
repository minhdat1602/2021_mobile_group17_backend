package com.nlu.service.Impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.CouponDTO;
import com.nlu.entity.CouponEntity;
import com.nlu.exceptions.ResourceExpiredException;
import com.nlu.exceptions.ResoureNotFoundException;
import com.nlu.repository.CouponRepository;

@Service
public class CouponService {

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private ModelMapper mapper;

	public CouponDTO getByCode(String code) {
		CouponEntity entity = couponRepository.findByCode(code).orElseThrow(() -> new ResoureNotFoundException(code));

		Date now = new Date(System.currentTimeMillis());
		if (entity.getBegin().before(now) && entity.getEnd().after(now)) {
			return mapper.map(entity, CouponDTO.class);
		} else {
			throw new ResourceExpiredException(code);
		}
	}

	public List<CouponEntity> getAll() {
		List<CouponEntity> coupon = couponRepository.findAll();
		return coupon;
	}

	public CouponEntity getById(long id) {
		CouponEntity coupon = couponRepository.findById(id);
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
