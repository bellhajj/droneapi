package com.bagudu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.model.Battery;
import com.bagudu.model.Drone;
import com.bagudu.model.Medication;
import com.bagudu.repository.BatteryRepository;
import com.bagudu.repository.DroneRepository;
import com.bagudu.repository.MedicationRepository;

@Service
public class DroneService {
    
    @Autowired
    private DroneRepository droneRepository;

    @Autowired 
    private MedicationRepository medicationRepository;
    
    @Autowired 
    private BatteryRepository batteryRepository;
    
    public DroneService(DroneRepository droneRepository) {
		this.droneRepository = droneRepository;
	}

	public List<Drone> getAllDrone(){
        List<Drone> drones = new ArrayList<>();
        droneRepository.findAll().forEach(drones::add);
        return drones;
    }
    
    public List<Drone> availableDrones(){
    	List<Drone> drones  = new ArrayList<>();
    	List<Drone> available = new ArrayList<>();
    	droneRepository.findAll().forEach(drones::add);
    	for(Drone d : drones) {
    		if(d.getMedication() == null) {
    			available.add(d);
    		}
    	}
    	return available;
    }
    
    public Drone getDrone(Long id){
       return droneRepository.findById(id).get();    	
    }
    
    public Drone addDrone(Drone drone){
    	Battery bt = batteryRepository.findById(drone.getBattery().getBatteryId()).get();
    		if(bt != null) {
    			drone.setBattery(bt);
    			return droneRepository.save(drone);
    		}    		
    		return null;         
    }
    
    public Drone saveDrone(Drone drone) {
    	return droneRepository.save(drone);
    }
    
    
    public Drone updateDrone(Long id, Drone drone){
    	
    	Drone d	= droneRepository.findById(id).orElse(null);
    	
    	Medication medication = medicationRepository.findById(drone.getMedication().getMedicationId()).orElse(null);
    	
    	d.setMedication(medication);
    	    	
    	return droneRepository.save(d);        
    	
    }
    
    public String deleteDrone(Long id){
        droneRepository.deleteById(id);
        return(droneRepository.findById(id).get().getDroneName() + " Deleted Successfully");
    }
    
    public Drone droneBattery(Long id) {
    	return droneRepository.findById(id).get();
    }
    
}
