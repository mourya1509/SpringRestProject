package com.infyRail.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.infyRail.entity.TrainEntity;

public class TrainDTO implements Serializable{
	
	Integer id;
	String trainName;
	String arrivalTime;
	String departureTime;
	Double fare;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "trainDTO [id=" + id + ", trainName=" + trainName + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + ", fare=" + fare + "]";
	}
	public static List<TrainDTO> changeTo(List<TrainEntity> entities){
		List<TrainDTO> dtos= new ArrayList<>();
		for(TrainEntity ent:entities) {
			TrainDTO dto=new TrainDTO();

			dto.setArrivalTime(ent.getArrivalTime());
			dto.setDepartureTime(ent.getDepartureTime());
			dto.setFare(ent.getFare());
			dto.setId(ent.getId());
			dto.setTrainName(ent.getTrainName());
			dtos.add(dto);
		}
		return dtos;
	}
	public static List<TrainEntity> change(List<TrainDTO> dtos){
		List<TrainEntity> entities= new ArrayList<>();
		for(TrainDTO dto:dtos) {
			TrainEntity ent=new TrainEntity();
			ent.setArrivalTime(dto.getArrivalTime());
			ent.setDepartureTime(dto.getDepartureTime());
			ent.setFare(dto.getFare());
			ent.setId(dto.getId());
			ent.setTrainName(dto.getTrainName());
			entities.add(ent);
		}
		return entities;
	}
	public static TrainDTO changes(TrainEntity ent) {
		TrainDTO dto=new TrainDTO();
		dto.setArrivalTime(ent.getArrivalTime());
		dto.setDepartureTime(ent.getDepartureTime());
		dto.setFare(ent.getFare());
		dto.setId(ent.getId());
		dto.setTrainName(ent.getTrainName());
		return dto;
	}
	public static TrainEntity changesTo(TrainDTO dto) {
		TrainEntity ent=new TrainEntity();
		ent.setArrivalTime(dto.getArrivalTime());
		ent.setDepartureTime(dto.getDepartureTime());
		ent.setFare(dto.getFare());
		ent.setId(dto.getId());
		ent.setTrainName(dto.getTrainName());
		return ent;
	}
	
	
}
