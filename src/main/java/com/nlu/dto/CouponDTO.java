package com.nlu.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CouponDTO extends BaseDto {
	private String code;

	private Double discount;

	private Date begin;

	private Date end;

	private Integer type;

}
