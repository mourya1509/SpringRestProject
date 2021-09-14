package com.infyRail.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.infyRail.entity.RouteEntity;

public class RouteDTO {
	
	@Min(value = 100)
	@Max(value = 999)
	Integer id;
	@NotEmpty(message="{route.source.must}")
	@Pattern(regexp="^[A-Za-z]+$",message= "{route.source.invalid}")
	String source;
	@NotEmpty(message="{route.destination.must}")
	@Pattern(regexp="^[A-Za-z]+$",message= "{route.destination.invalid}")
	String destination;
	@NotEmpty
	List<TrainDTO> trainList=new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<TrainDTO> getTrainList() {
		return trainList;
	}
	public void setTrainList(List<TrainDTO> trainList) {
		this.trainList = trainList;
	}
	
	@Override
	public String toString() {
		return "routeDTO [id=" + id + ", source=" + source + ", destination=" + destination + ", trainList=" + trainList
				+ "]";
	}
	public static RouteDTO changeTo(RouteEntity entity) {
		RouteDTO dto = new RouteDTO();
		dto.setDestination(entity.getDestination());
		dto.setId(entity.getId());
		dto.setSource(entity.getSource());
		dto.setTrainList(TrainDTO.changeTo(entity.getTrainList()));
		return dto;
	}
	public static RouteEntity change(RouteDTO dto) {
		RouteEntity entity = new RouteEntity();
		entity.setDestination(dto.getDestination());
		entity.setId(dto.getId());
		entity.setSource(dto.getSource());
		entity.setTrainList(TrainDTO.change(dto.getTrainList()));
		return entity;
	}
}

