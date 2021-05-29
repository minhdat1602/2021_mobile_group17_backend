package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.SizeEntity;
import com.nlu.repository.SizeRepository;

@Service
public class SizeService {
	@Autowired
	private SizeRepository sizeRepository;
	
	public List<SizeEntity> getAll(){
		List<SizeEntity> sizes = sizeRepository.findAll();
		return sizes;
	}
}
