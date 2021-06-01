package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.ImageEntity;
import com.nlu.repository.ImageRepository;

@Service
public class ImageService {
	@Autowired
	private ImageRepository imageRepository;

	public List<ImageEntity> getAll() {
		List<ImageEntity> images = imageRepository.findAll();
		return images;
	}

	public ImageEntity getById(long id) {
		ImageEntity image = imageRepository.findById(id);
		return image;
	}

	public ImageEntity insert(ImageEntity imageEntity) {
		ImageEntity image = imageRepository.save(imageEntity);
		return image;
	}

	public ImageEntity update(ImageEntity imageEntity) {
		ImageEntity image = imageRepository.save(imageEntity);
		return image;
	}

	public void delete(long id) {
		imageRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			imageRepository.deleteById(id);
	}
}
