package com.bagudu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bagudu.model.Drone;
import com.bagudu.service.DroneService;

@RestController
public class DroneController {
    
    @Autowired
    private DroneService droneService;
    
    //Load a drone
    @RequestMapping(method=RequestMethod.PUT, value="/drone/load/{id}")
    public Drone loadDrone(@RequestBody Drone drone, @PathVariable Long id){
    	return droneService.updateDrone(id, drone);        	
    }
    
    //Find all Drones
    @RequestMapping("/drone/find/all")
    public List<Drone> getAllDrones() {
    	return droneService.getAllDrone();
    }
    
    //register a Drone
    @RequestMapping(method=RequestMethod.POST, value="/drone/register")
    public Drone registerDrone(@RequestBody Drone drone) {
    	return droneService.addDrone(drone);
    }
    
    //Find Available Drones
    @RequestMapping("/drone/available")
    public List<Drone> availableDrones(){
    	return droneService.availableDrones();    	
    }
    
    //Check Drone Battery
    @RequestMapping("/drone/battery/{id}")
    public Drone droneBattery(@PathVariable Long id) {
    	return droneService.droneBattery(id);
    }
   
}