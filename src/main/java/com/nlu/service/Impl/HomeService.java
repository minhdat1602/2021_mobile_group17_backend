package com.nlu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.HomeEntity;
import com.nlu.repository.HomeRepository;

@Service
public class HomeService {
	
	@Autowired
	private HomeRepository homeRepository;
	
	public List<HomeEntity> findByIsHot(){
		return homeRepository.findByHotAndActive(1, 1);
	}
	
	public List<HomeEntity> findByIsHighLight(){
		return homeRepository.findByHighlightAndActive(1, 1);
	}
}
