package com.nlu.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.StatusDTO;
import com.nlu.entity.StatusEntity;
import com.nlu.repository.StatusRepository;

@Service
public class StatusService {
	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private ModelMapper mapper;

	public List<StatusDTO> getAll() {
		List<StatusEntity> statuses = statusRepository.findAll();
		List<StatusDTO> results = new ArrayList<StatusDTO>();
		for (StatusEntity item : statuses) {
			results.add(mapper.map(item, StatusDTO.class));
		}
		return results;
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
