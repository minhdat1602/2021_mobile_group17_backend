package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.StatusEntity;
import com.nlu.repository.StatusRepository;

@Service
public class StatusService {
	@Autowired
	private StatusRepository statusRepository;

	public List<StatusEntity> getAll() {
		List<StatusEntity> statuses = statusRepository.findAll();
		return statuses;
	}

	public StatusEntity getById(long id) {
		StatusEntity status = statusRepository.findById(id);
		return status;
	}

	public StatusEntity insert(StatusEntity statusEntity) {
		StatusEntity status = statusRepository.save(statusEntity);
		return status;
	}

	public StatusEntity update(StatusEntity statusEntity) {
		StatusEntity status = statusRepository.save(statusEntity);
		return status;
	}

	public void delete(long id) {
		statusRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			statusRepository.deleteById(id);
	}
}
