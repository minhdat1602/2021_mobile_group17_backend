package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.HomeEntity;

@Repository
public interface HomeRepository extends JpaRepository<HomeEntity, Long> {
	
	public List<HomeEntity> findByIsHot(Integer isHot);
	public List<HomeEntity> findByIsHighLight(Integer isHighLight);

}
