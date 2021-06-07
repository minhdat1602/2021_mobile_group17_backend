package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.ProductEntity;
import com.nlu.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<ProductEntity> getAll() {
		return productRepository.findAll();
	}

	public List<ProductEntity> getDiscount() {
		return productRepository.findByDiscountGreaterThan(0.0);
	}

	public ProductEntity getById(long id) {
		return productRepository.findById(id);
	}

	public List<ProductEntity> getByCategoryId(long categoryId) {
		List<ProductEntity> products = productRepository.findByCategoryId(categoryId);
		return products;
	}

	public List<ProductEntity> getByTypeId(long typeId) {
		List<ProductEntity> products = productRepository.findByTypeId(typeId);
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
		List<ProductEntity> products = productRepository.findByCategoryIdAndTypeId(categoryId, typeId);
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
