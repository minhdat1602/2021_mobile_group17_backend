package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.ColorEntity;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity, Long>{
	List<ColorEntity> findAll();
}
