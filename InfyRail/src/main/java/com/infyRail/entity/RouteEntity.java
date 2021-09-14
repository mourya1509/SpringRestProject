package com.infyRail.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class RouteEntity {
    @Id
    @GenericGenerator(name = "route_id", strategy = "com.infyRail.entity.generator.CustomIDGenerator")
    @GeneratedValue(generator = "route_id")  
    @Column(name="route_id")
	Integer id;
	String source;
	String destination;

	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER ,orphanRemoval = true)
	 @JoinColumn(name = "list_id", referencedColumnName = "route_id")
	private List<TrainEntity> trainList=new ArrayList<>();
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
	public List<TrainEntity> getTrainList() {
		return trainList;
	}
	public void setTrainList(List<TrainEntity> trainList) {
		this.trainList.clear();
	    if (trainList != null) {
	        this.trainList.addAll(trainList);
	    }
	}
	
	@Override
	public String toString() {
		return "RouteEntity [id=" + id + ", source=" + source + ", destination=" + destination + ", trainList="
				+ trainList + "]";
	}
	
}
