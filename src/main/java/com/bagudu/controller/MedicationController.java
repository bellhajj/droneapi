package com.bagudu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bagudu.model.Medication;
import com.bagudu.service.MedicationService;

@RestController
public class MedicationController {
    
    @Autowired
    private MedicationService medicationService;  
    
    //Register a medication
    @RequestMapping(method=RequestMethod.POST, value="/medication/register")
    public Medication registerMedication(@RequestBody Medication medication){
        return medicationService.addMedication(medication);       
    }
        
    //Find all Medication
    @RequestMapping("/medication/find/all")
    public List<Medication> getAllMedication() {
    	return medicationService.getAllMedication();
    } 
    
    //Check Loaded Medication
    @RequestMapping("/drone/medication/{id}")
    public Medication loadedMedication(@PathVariable Long id) {
    	return medicationService.getMedication(id);
    	
    }
    
}