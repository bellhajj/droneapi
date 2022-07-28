package com.bagudu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "drone")
public class Drone {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long droneId;
    
    @Column(name = "drone_name")
    private String droneName;
    
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "batteryId", referencedColumnName = "batteryId")
    private Battery battery;     
      
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicationId", referencedColumnName = "medicationId")
    private Medication medication;
    
    public Drone(){
        
    }
    
    public void setBattery(Battery battery) {
    	this.battery = battery;
    }
    
    public Battery getBattery() {
    	return battery;
    }
    
    public void setMedication(Medication medication) {
    	this.medication = medication;
    }
    
    public Medication getMedication() {
    	return medication;
    }
    
    public Drone(Long droneId, String droneName, Battery battery, Medication medication){
        this.droneId = droneId;
        this.droneName = droneName;
        this.battery = battery;
        this.medication = medication;
    }
   
      
    public void setDroneId(Long droneId){
        this.droneId = droneId;
    }
    
    public Long getDroneId(){
        return droneId;
    }
    
    public void setDroneName(String droneName){
        this.droneName = droneName;
    }
    
    public String getDroneName(){
        return droneName;
    }    
        
  }
