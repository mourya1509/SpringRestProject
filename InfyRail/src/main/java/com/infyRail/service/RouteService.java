package com.infyRail.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infyRail.dto.RouteDTO;
import com.infyRail.dto.TrainDTO;
import com.infyRail.entity.RouteEntity;
import com.infyRail.entity.TrainEntity;
import com.infyRail.repo.RouteRepo;

@Service
public class RouteService {

	@Autowired
	RouteRepo routeRepo;
	
	public String createRoute(RouteDTO routeDTO) {
		RouteEntity en=RouteDTO.change(routeDTO);
		routeRepo.saveAndFlush(en);
		System.out.println("id "+en.getId());
		return Integer.toString(en.getId());
	}
	public RouteDTO fetchRoute(String id) {
		Integer Id=Integer.parseInt(id);
		Optional<RouteEntity> en=routeRepo.findById(Id);
		if(en.isPresent()) {
			RouteDTO dto=RouteDTO.changeTo(en.get());
			return dto;
		}
		return null;	
	}
	public List<TrainDTO> fetchTrain(String source,String destination) {
		Optional<RouteEntity> ent=routeRepo.findBySourceAndDestination(source, destination);
		if(ent.isPresent()) {
			List<TrainDTO> trainDTO=TrainDTO.changeTo(ent.get().getTrainList());
			return trainDTO;
		}
		return null;
	}
	public RouteDTO updateRoute(String id,String source,String destination) {
		Optional<RouteEntity> ent=routeRepo.findById(Integer.parseInt(id));
		if(ent.isPresent()) {
			RouteEntity entity=ent.get();
			entity.setSource(source);
			entity.setDestination(destination);
			routeRepo.saveAndFlush(entity);
			RouteDTO routeDTO=RouteDTO.changeTo(entity);
			return routeDTO;
		}
		return null;
	}
	public RouteDTO updateRoute1(String id,RouteDTO routeDTO) {
		Optional<RouteEntity> ent=routeRepo.findById(Integer.parseInt(id));
		if(ent.isPresent()) {
			RouteEntity en=RouteDTO.change(routeDTO);
			RouteEntity entity=ent.get();
			if(en.getDestination()!=null) {
				entity.setDestination(en.getDestination());
			}
			if(en.getId()!=null) {
				entity.setId(en.getId());
			}
			if(en.getSource()!=null) {
				entity.setSource(en.getSource());
			}
			if(en.getTrainList()!=null) {
				List<TrainEntity> te=en.getTrainList();
				 te.addAll(entity.getTrainList());
				entity.setTrainList(te);
			}
			routeRepo.saveAndFlush(entity);
			RouteDTO routeDTO1=RouteDTO.changeTo(entity);
			return routeDTO1;
		}
		return null;
	}
	public RouteDTO deleteTrain(String route,String train) {
		Optional<RouteEntity> ent=routeRepo.findById(Integer.parseInt(route));
		if(ent.isPresent()) {
			RouteEntity entity=ent.get();
			List<TrainEntity> trainEnt=entity.getTrainList();
			trainEnt.removeIf(o->o.getId()==Integer.parseInt(train));
			entity.setTrainList(trainEnt);
			routeRepo.saveAndFlush(entity);	
			RouteDTO dto=RouteDTO.changeTo(entity);
			return dto;
		}
		return null;
	}
}
