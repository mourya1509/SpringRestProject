package com.infyRail.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.infyRail.entity.TrainEntity;

public interface TrainRepo extends JpaRepository<TrainEntity,Integer>{

	
	
}
