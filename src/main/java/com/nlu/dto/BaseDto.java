package com.nlu.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDto {
	private Long id;
	private Date createdDate;
	private Date modifiedDate;
}
