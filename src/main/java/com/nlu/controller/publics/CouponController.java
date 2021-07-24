package com.nlu.controller.publics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.CouponDTO;
import com.nlu.service.Impl.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	private CouponService couponService;

	@GetMapping("/{code}")
	public CouponDTO getCoupon(@PathVariable(name = "code") String code) {
		return couponService.getByCode(code);
	}
}
