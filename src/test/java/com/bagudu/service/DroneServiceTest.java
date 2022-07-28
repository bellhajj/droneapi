package com.bagudu.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bagudu.model.Drone;
import com.bagudu.repository.DroneRepository;
import com.bagudu.repository.MedicationRepository;


@ExtendWith(MockitoExtension.class)
class DroneServiceTest {

	@Mock
	private DroneRepository droneRepository;
	
	@Mock
	private MedicationRepository medicationRepository;
	
	@InjectMocks
	private DroneService droneService;
	
	@BeforeEach
	public void setUp() {
		
		droneService = new DroneService(droneRepository);
	}
	
	
	@Test
	public void testCreateDrone() {
		//Given
		
		Drone drone = new Drone();
		drone.setDroneId(1L);
		drone.setDroneName("Drone");
		drone.setBattery(null);
		drone.setMedication(null);	
		
		//When
		Mockito.when(droneRepository.save(drone)).thenReturn(drone); 
		
		//Then		
		assertThat(droneService.saveDrone(drone)).isEqualTo(drone);
	}
	
	
	@Test
	public void testGetDroneById() {
		//Given
		Drone drone = new Drone();
		drone.setDroneId(1L);
		drone.setDroneName("Drone");
		drone.setBattery(null);
		drone.setMedication(null);
		
		//When
		Mockito.when(droneRepository.findById(1L)).thenReturn(Optional.of(drone));
		
		//Then
		assertThat(droneService.getDrone(1L)).isEqualTo(drone);
	}
	
	@Test
	public void testDeleteDrone() {
		//Given
		Drone drone = new Drone();
		drone.setDroneId(1L);
		drone.setDroneName("Drone");
		drone.setBattery(null);
		drone.setMedication(null);
		
		//When
		Mockito.when(droneRepository.existsById(drone.getDroneId())).thenReturn(false);
		
		//Then
		assertFalse(droneRepository.existsById(drone.getDroneId()));
	}
	
	@Test
	public void testGetAllDrones() {
		//Given
		Drone drone1 = new Drone();
		drone1.setDroneId(1L);
		drone1.setDroneName("Drone");
		drone1.setBattery(null);
		drone1.setMedication(null);
		
		Drone drone2 = new Drone();
		drone2.setDroneId(1L);
		drone2.setDroneName("Drone");
		drone2.setBattery(null);
		drone2.setMedication(null);
		
		List<Drone> droneList = new ArrayList<>();
		droneList.add(drone1);
		droneList.add(drone2);
		
		//When
		Mockito.when(droneRepository.findAll()).thenReturn(droneList);
		
		//Then
		assertThat(droneService.getAllDrone()).isEqualTo(droneList);
	}
	
	
	

}
