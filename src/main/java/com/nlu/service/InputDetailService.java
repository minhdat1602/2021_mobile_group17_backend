package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.InputDetailEntity;
import com.nlu.repository.InputDetailRepository;

@Service
public class InputDetailService {
	@Autowired
	private InputDetailRepository inputDetailRepository;

	public List<InputDetailEntity> getAll() {
		List<InputDetailEntity> inputDetails = inputDetailRepository.findAll();
		return inputDetails;
	}

	public InputDetailEntity getById(long id) {
		InputDetailEntity inputDetail = inputDetailRepository.findById(id);
		return inputDetail;
	}

	public InputDetailEntity insert(InputDetailEntity inputDetailEntity) {
		InputDetailEntity inputDetail = inputDetailRepository.save(inputDetailEntity);
		return inputDetail;
	}

	public InputDetailEntity update(InputDetailEntity inputDetailEntity) {
		InputDetailEntity inputDetail = inputDetailRepository.save(inputDetailEntity);
		return inputDetail;
	}

	public void delete(long id) {
		inputDetailRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			inputDetailRepository.deleteById(id);
	}
}
