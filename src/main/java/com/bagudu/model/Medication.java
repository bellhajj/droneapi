package com.bagudu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicationId;
    
    @Column(name = "medication_name")
    private String medicationName;
    
    private String description;    
           
    @JsonBackReference
    @OneToOne(mappedBy = "medication")
    private Drone drone;
       
    public Medication(){
        
    }
    
    public Medication(Long medicationId, String medicationName, String description){
        this.medicationId = medicationId;
        this.medicationName = medicationName;
        this.description = description;
    }
    
    public Drone getDrone() {
        return drone;
    }
    
    public void setDrone(Drone drone) {
        this.drone = drone;
    }
    
    public void setMedicationId(Long medicationId){
        this.medicationId = medicationId;
    }
    
    public Long getMedicationId(){
        return medicationId;
    }
    
    public void setMedicationName(String medicationName){
        this.medicationName = medicationName;
    }
    
    public String getMedicationName(){
        return medicationName;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }
}
