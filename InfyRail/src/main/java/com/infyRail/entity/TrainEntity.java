package com.infyRail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "train")
public class TrainEntity {
		@Id
		@Column(nullable = false)
		Integer id;
		@Column(name = "train_name")
		String trainName;
		@Column(name = "arrival_time")
		String arrivalTime;
		@Column(name = "departure_time")
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
			return "TrainEntity [id=" + id + ", trainName=" + trainName + ", arrivalTime=" + arrivalTime
					+ ", departureTime=" + departureTime + ", fare=" + fare + "]";
		}
		
}
