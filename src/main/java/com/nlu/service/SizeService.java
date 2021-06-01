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
	public SizeEntity getById(long id) {
		SizeEntity size = sizeRepository.findById(id);
		return size;
	}

	public SizeEntity insert(SizeEntity sizeEntity) {
		SizeEntity size = sizeRepository.save(sizeEntity);
		return size;
	}

	public SizeEntity update(SizeEntity sizeEntity) {
		SizeEntity size = sizeRepository.save(sizeEntity);
		return size;
	}

	public void delete(long id) {
		sizeRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			sizeRepository.deleteById(id);
	}
}
