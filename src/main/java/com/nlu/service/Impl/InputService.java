package com.nlu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.InputEntity;
import com.nlu.repository.InputRepository;

@Service
public class InputService {

	@Autowired
	private InputRepository inputRepository;

	public List<InputEntity> getAll() {
		List<InputEntity> input = inputRepository.findAll();
		return input;
	}

	public InputEntity getById(long id) {
		InputEntity input = inputRepository.findById(id);
		return input;
	}

	public InputEntity insert(InputEntity inputEntity) {
		InputEntity input = inputRepository.save(inputEntity);
		return input;
	}

	public InputEntity update(InputEntity inputEntity) {
		InputEntity input = inputRepository.save(inputEntity);
		return input;
	}

	public void delete(long id) {
		inputRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			inputRepository.deleteById(id);
	}
	
}
