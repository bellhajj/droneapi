package com.bagudu.service;

import java.util.Date;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.model.Battery;
import com.bagudu.model.Drone;
import com.bagudu.repository.BatteryRepository;
import com.bagudu.repository.DroneRepository;

@Service
public class BatteryService {

	@Autowired
	private DroneRepository droneRepository;
	
	@Autowired
	private BatteryRepository batteryRepository;
	
	
	public Battery addBattery(Battery battery){    	
        return batteryRepository.save(battery);        
    }
	
	public void updateAllCharge(Long rate){
		List<Drone> drones = droneRepository.findAll();
		
		/*for(Drone drone : drones) {			
			if(drone.getMedication() != null && drone.getBattery().getCharge() > 0) {
				Battery battery = drone.getBattery();
				battery.setCharge(battery.getCharge() - rate);
				drone.setBattery(battery);
				droneRepository.save(drone);
			}
		
		}*/		
		
		drones.stream().forEach((drone) -> {
			if(drone.getMedication() != null && drone.getBattery().getCharge() > 0) {
				Battery battery = drone.getBattery();
				battery.setCharge(battery.getCharge() - rate);
				drone.setBattery(battery);
				droneRepository.save(drone);
			}
		});
		
		
		System.out.println(new Date().toString());
	}
}
