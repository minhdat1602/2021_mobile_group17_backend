package com.nlu.service.Impl;

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

	public TypeEntity getById(long id) {
		TypeEntity type = typeRepository.findById(id);
		return type;
	}

	public TypeEntity insert(TypeEntity typeEntity) {
		TypeEntity type = typeRepository.save(typeEntity);
		return type;
	}

	public TypeEntity update(TypeEntity typeEntity) {
		TypeEntity type = typeRepository.save(typeEntity);
		return type;
	}

	public void delete(long id) {
		typeRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			typeRepository.deleteById(id);
	}
}
