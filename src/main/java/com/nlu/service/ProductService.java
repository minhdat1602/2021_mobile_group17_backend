package com.nlu.service;

import java.util.List;

import com.nlu.dto.ProductDTO;

public interface ProductService {
	ProductDTO findById(Long id);

	List<ProductDTO> adminGetAll();
}
