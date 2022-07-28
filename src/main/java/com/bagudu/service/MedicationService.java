package com.bagudu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.model.Drone;
import com.bagudu.model.Medication;
import com.bagudu.repository.DroneRepository;
import com.bagudu.repository.MedicationRepository;

@Service
public class MedicationService {
    
    @Autowired
    private MedicationRepository medicationRepository;
    
    @Autowired
    private DroneRepository droneRepository;
    
    public MedicationService(MedicationRepository medicationRepository) {
		this.medicationRepository = medicationRepository;
	}

	public List<Medication> getAllMedication(){
        List<Medication> medication = new ArrayList<>();
        medicationRepository.findAll().forEach(medication::add);       
        return medication;
    }
    
    public Medication getMedication(Long id){
    	Drone drone = droneRepository.findById(id).orElse(null);
    	if(drone == null) {    		
    		throw new RuntimeException("Drone doesnt exist");
    	}
    	if(drone.getMedication() == null) {
    		throw new RuntimeException("No Medication loaded on " + drone.getDroneName());
    	}
    	return drone.getMedication();        
    }
    
    public Medication addMedication(Medication medication){
    	return medicationRepository.save(medication);
    	//return(medication.getMedicationName() + " Register Successfully");
    }
    
    public Medication updateMedication(Long id, Medication medication){
        return medicationRepository.save(medication);
    }
    
    public void deleteMedication(Long id){
        medicationRepository.deleteById(id);
    }
    
}