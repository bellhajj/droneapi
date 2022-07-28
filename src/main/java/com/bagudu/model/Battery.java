package com.bagudu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "battery")
public class Battery {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long batteryId;
	
	private Long charge;
	
	private String model;
	
	@JsonBackReference
    @OneToOne(mappedBy = "battery")
	private Drone drone;
	
	public void setCharge(Long charge) {
		this.charge = charge;
	}
	
	public Long getCharge() {
		return charge;
	}

	public Long getBatteryId() {
		return batteryId;
	}

	public void setBatteryId(Long batteryId) {
		this.batteryId = batteryId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}
	
	

}
