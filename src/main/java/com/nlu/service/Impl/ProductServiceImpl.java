package com.nlu.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.ProductDTO;
import com.nlu.entity.ProductEntity;
import com.nlu.exceptions.ResoureNotFoundException;
import com.nlu.repository.ProductRepository;
import com.nlu.repository.impl.ProductCustomRepositoryImpl;
import com.nlu.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private ProductCustomRepositoryImpl productCustomRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository,
			ProductCustomRepositoryImpl productCustomRepository) {
		this.productRepository = productRepository;
		this.productCustomRepository = productCustomRepository;
	}

	@Autowired
	private ModelMapper mapper;
	
	public List<ProductDTO> findByKeyword(String keyword){
		return productCustomRepository.findByKeyword(keyword)
				.stream()
				.map((product) -> mapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
		
	}

	public List<ProductDTO> adminGetAll() {
		return productRepository.findAll().stream().map((product) -> mapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}

	public List<ProductEntity> getAll() {
		return productRepository.findAll();
	}

	public List<ProductEntity> getDiscount() {
		return productRepository.findByDiscountGreaterThan(0.0);
	}

	public List<ProductEntity> getHot() {
		return productRepository.findByIsHot(1);
	}

	public List<ProductEntity> getHighligh() {
		return productRepository.findByIsHighLigh(1);
	}

	public ProductDTO findById(Long id) {
		ProductEntity entity = this.productRepository.findById(id).orElseThrow(() -> new ResoureNotFoundException(id));
		return mapper.map(entity, ProductDTO.class);
	}

	public List<ProductEntity> getByCategoryId(long categoryId) {
		List<ProductEntity> products = productRepository.findByCategoryId(categoryId);
		return products;
	}

	public List<ProductEntity> getByTypeId(long typeId) {
		List<ProductEntity> products = productRepository.findByTypesId(typeId);
		return products;
	}

	public List<ProductEntity> getNew() {
		List<ProductEntity> products = productRepository.findByIsNew(1);
		return products;
	}

	public List<ProductEntity> getByCollectionId(long collectionId) {
		List<ProductEntity> products = productRepository.findByCollectionId(collectionId);
		return products;
	}

	public List<ProductEntity> getByCollectionBrandId(long brandId) {
		List<ProductEntity> products = productRepository.findByCollectionBrandId(brandId);
		return products;
	}

	public List<ProductEntity> getByCategoryIdAndTypeId(long categoryId, long typeId) {
		List<ProductEntity> products = productRepository.findByCategoryIdAndTypesId(categoryId, typeId);
		return products;
	}

	public ProductEntity insert(ProductEntity productEntity) {
		ProductEntity product = productRepository.save(productEntity);
		return product;
	}

	public ProductEntity update(ProductEntity productEntity) {
		ProductEntity product = productRepository.save(productEntity);
		return product;
	}

	public void delete(long id) {
		productRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			productRepository.deleteById(id);
	}
}
