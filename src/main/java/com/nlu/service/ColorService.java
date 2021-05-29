package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.ColorEntity;
import com.nlu.repository.ColorRepository;

@Service
public class ColorService {
	@Autowired
	private ColorRepository colorRepository;

	public List<ColorEntity> getAll() {
		List<ColorEntity> colors = colorRepository.findAll();
		return colors;
	}
}
