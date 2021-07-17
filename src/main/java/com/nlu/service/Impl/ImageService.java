package com.nlu.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.ImageEntity;
import com.nlu.repository.ImageRepository;

@Service
public class ImageService {
	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private ModelMapper mapper;

	public List<ImageEntity> getAll() {
		List<ImageEntity> images = imageRepository.findAll();
		return images;
	}

	public ImageEntity getById(long id) {
		ImageEntity image = imageRepository.findById(id);
		return image;
	}

	public ImageEntity save(ImageEntity imageDTO) {
		ImageEntity imageEntity = new ImageEntity();
		if (imageDTO.getId() != null) {
			ImageEntity oldImageEntity = imageRepository.findById(imageDTO.getId().longValue());
			oldImageEntity = mapper.map(imageDTO, ImageEntity.class);
			imageEntity = oldImageEntity;
		} else {
			imageEntity = mapper.map(imageDTO, ImageEntity.class);
		}

		imageEntity = imageRepository.save(imageEntity);
		return imageEntity;

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
