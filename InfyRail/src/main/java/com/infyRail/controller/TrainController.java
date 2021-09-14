package com.infyRail.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infyRail.dto.TrainDTO;
import com.infyRail.service.TrainService;

@RestController
@RequestMapping("/trains")
@Validated
public class TrainController {

	@Autowired
	TrainService trainService;
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<String> createTrain(@RequestBody TrainDTO trainDTO) {
		return ResponseEntity.ok(trainService.createTrain(trainDTO));
	}
	@PutMapping(value = "/{trainid}")
	public ResponseEntity<String> updateTrain(@PathVariable("trainid") String id,@RequestParam String fare)  								  
	{
		
		System.out.println("fare "+fare);
		return ResponseEntity.ok(trainService.updateTrain(id,fare));
	}
	
	
}
