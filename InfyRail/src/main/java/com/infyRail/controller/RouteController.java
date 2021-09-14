package com.infyRail.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infyRail.dto.RouteDTO;
import com.infyRail.dto.TrainDTO;
import com.infyRail.service.RouteService;


@RestController
@RequestMapping("/routes")
@Validated
public class RouteController {
	@Autowired
	RouteService routeService;
	@PostMapping(consumes="application/json")
	public ResponseEntity<String> createRoute(@Valid @RequestBody RouteDTO routeDTO){
		return ResponseEntity.ok(routeService.createRoute(routeDTO));
	}
	@GetMapping(value = "/{routeId}")
	public ResponseEntity<RouteDTO> fetchRoute(@PathVariable("routeId") String id){
		return ResponseEntity.ok(routeService.fetchRoute(id));
	}
	@GetMapping(value = "/trains")
	public ResponseEntity<List<TrainDTO>> fetchTrain(@RequestParam String source,@RequestParam String destination){
		return ResponseEntity.ok(routeService.fetchTrain(source,destination));
	}
	@PutMapping(value = "/{routeId}")
	public ResponseEntity<RouteDTO> updateRoute(@PathVariable("routeId") String id,@MatrixVariable Map<String, String> map) 
	 								  
	{
			return ResponseEntity.ok(routeService.updateRoute(id,map.get("source"),map.get("destination")));		
	}
	@PutMapping(value = "/{routeid}/json")
	public ResponseEntity<RouteDTO> updateTrain(@PathVariable("routeid") String id,@Valid @RequestBody RouteDTO routeDTO)  								  
	{
		return ResponseEntity.ok(routeService.updateRoute1(id,routeDTO));
	}
	@DeleteMapping(value="/{routeId}/{trainId}")
	public ResponseEntity<RouteDTO> deleteTrain(@PathVariable("routeId") String route,@PathVariable("trainId") String train){
		return ResponseEntity.ok(routeService.deleteTrain(route, train));
	}
}
