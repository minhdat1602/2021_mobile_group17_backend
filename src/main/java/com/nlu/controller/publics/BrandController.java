package com.nlu.controller.publics;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.BrandDto;
import com.nlu.exceptions.ResoureNotFoundException;
import com.nlu.service.Impl.BrandService;

@RestController
@RequestMapping("brand")
public class BrandController {

	private final BrandService brandService;

	@Autowired
	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping("all")
	public List<BrandDto> getAll() {
		return brandService.getAll();
	}

	@GetMapping("{id}")
	public BrandDto findById(@PathVariable Long id) {
		return this.brandService.getById(id);
	}

	@PostMapping()
	public BrandDto insert(@RequestBody @Valid BrandDto brandDTO) {
		brandDTO.setId(null);
		return this.brandService.save(brandDTO);
	}

	@PutMapping()
	public BrandDto update(@RequestBody @Valid BrandDto brandDTO) {
		if (brandDTO.getId() == null || !this.brandService.existId(brandDTO.getId()))
			throw new ResoureNotFoundException("brand");
		else
			return this.brandService.save(brandDTO);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		try {
			this.brandService.deleteById(id);
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			throw new ResoureNotFoundException(id);
		}
	}

}
