package com.infyRail.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infyRail.dto.TrainDTO;
import com.infyRail.entity.TrainEntity;
import com.infyRail.repo.TrainRepo;

@Service
public class TrainService {

	@Autowired
	TrainRepo trainRepo;
	
	public String createTrain(TrainDTO trainDTO) {
		TrainEntity en=TrainDTO.changesTo(trainDTO);
		trainRepo.saveAndFlush(en);
		System.out.println("id "+en.getId());
		return Integer.toString(en.getId());
	}
	
	public String updateTrain(String id, String fare) {
		
		Optional<TrainEntity> en=trainRepo.findById(Integer.parseInt(id));
		try {
			TrainEntity tent=en.get();
			tent.setFare(Double.parseDouble(fare));
			trainRepo.saveAndFlush(tent);
			return "Success: Fare gets Updated";
		} catch (Exception e) {
			return "Failed: Could not update the fare";
			// TODO: handle exception
		}
	}
	
	
	
}

//{
//"source": "delhi",
//"destination": "jaipur",
//"trainList":[{
//    "id":"3",
//    "trainName":"A",
//    "arrivalTime":"8:00 AM",
//    "departureTime":"10:00 PM",
//    "fare":"2500.00"
//},{
//    "id":"4",
//    "trainName":"B",
//    "arrivalTime":"9:00 AM",
//    "departureTime":"11:00 PM",
//    "fare":"2500.00"
//}]
//}