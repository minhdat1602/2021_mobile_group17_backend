package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.TypeEntity;
import com.nlu.repository.TypeRepository;

@Service
public class TypeService {

	@Autowired
	private TypeRepository typeRepository;

	public List<TypeEntity> getAll() {
		List<TypeEntity> types = typeRepository.findAll();
		return types;
	}
}
