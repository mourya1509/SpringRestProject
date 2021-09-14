package com.infyRail.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infyRail.entity.RouteEntity;

@Repository
public interface RouteRepo extends JpaRepository<RouteEntity,Integer>{
	
	
	Optional<RouteEntity> findById(Integer id);
	Optional<RouteEntity> findBySourceAndDestination(String source,String destination);
}
