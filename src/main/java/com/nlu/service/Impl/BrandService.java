package com.nlu.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.BrandDTO;
import com.nlu.entity.BrandEntity;
import com.nlu.exceptions.ResoureNotFoundException;
import com.nlu.repository.BrandRepository;


@Service
public class BrandService {

	private final BrandRepository brandRepository;

	@Autowired
	public BrandService(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}
	
	@Autowired
	private ModelMapper mapper;
	
	public boolean existId(Long id) { 
		BrandEntity entity =  brandRepository.findById(id.longValue());
		return  entity != null ? true : false;
	}
	
	public List<BrandDTO> getAll() {
		return this.brandRepository
				.findAll()
				.stream()
				.map((brand) -> mapper.map(brand, BrandDTO.class))
				.collect(Collectors.toList());
	}

	public BrandDTO getById(Long id) {
		BrandEntity brand = brandRepository.findById(id)
				.orElseThrow(() -> new ResoureNotFoundException(id));
		return mapper.map(brand, BrandDTO.class);
	}

	public BrandDTO save(BrandDTO brandDTO) {
		BrandEntity brandEntity = new BrandEntity();
		if(brandDTO.getId() == null) {
			brandEntity = mapper.map(brandDTO, BrandEntity.class);
		}else {
			BrandEntity old = this.brandRepository.findById(brandDTO.getId().longValue());
			old = mapper.map(brandDTO, BrandEntity.class);
			brandEntity = old;
		}
		
		brandEntity = this.brandRepository.save(brandEntity);
		
		return mapper.map(brandEntity, BrandDTO.class);
	}

	public void deleteById(Long id) {
		brandRepository.deleteById(id);
	}

	public void deleteAll(Long[] ids) {
		for (Long id : ids)
			brandRepository.deleteById(id);
	}

}
