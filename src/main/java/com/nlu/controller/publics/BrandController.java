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

import com.nlu.dto.BrandDTO;
import com.nlu.exceptions.ResoureNotFoundException;
import com.nlu.payload.response.MessageResponse;
import com.nlu.service.Impl.BrandService;

@RestController
@RequestMapping("brand")
public class BrandController {

	private final BrandService brandService;

	@Autowired
	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping("/all")
	public List<BrandDTO> getAll() {
		return brandService.getAll();
	}

	@GetMapping("{id}")
	public BrandDTO findById(@PathVariable Long id) {
		return this.brandService.getById(id);
	}

	@PostMapping()
	public BrandDTO insert(@RequestBody @Valid BrandDTO brandDTO) {
		brandDTO.setId(null);
		return this.brandService.save(brandDTO);
	}

	@PutMapping()
	public BrandDTO update(@RequestBody @Valid BrandDTO brandDTO) {
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
