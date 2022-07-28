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
import com.bagudu.model.Medication;
import com.bagudu.repository.DroneRepository;
import com.bagudu.repository.MedicationRepository;

@ExtendWith(MockitoExtension.class)
class MedicationServiceTest {
	
	@Mock
	private MedicationRepository medicationRepository;
	
	@Mock
	private DroneRepository droneRepository;
	
	@InjectMocks
	private MedicationService medicationService;
	
	@InjectMocks
	private DroneService droneService;
	
	@BeforeEach
	public void setUp() {
		
		medicationService = new MedicationService(medicationRepository);
	}
	
	
	@Test
	public void testGetAllMedication() {
		//Given
		Medication medication = new Medication();
		medication.setMedicationId(1L);
		medication.setMedicationName("Medication");
		medication.setDescription("Description");
		
		Medication medication2 = new Medication();
		medication2.setMedicationId(1L);
		medication2.setMedicationName("Medication");
		medication2.setDescription("Description");
				
		List<Medication> medicationList = new ArrayList<>();
		medicationList.add(medication);
		medicationList.add(medication2);
		
		//When
		Mockito.when(medicationRepository.findAll()).thenReturn(medicationList);
		
		//Then
		assertThat(medicationService.getAllMedication()).isEqualTo(medicationList);
	}
	
	@Test
	public void testGetMedicationById() {
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
	public void testCreateMedication() {
		//Given
		Medication medication = new Medication();
		medication.setMedicationId(1L);
		medication.setMedicationName("Medication");
		medication.setDescription("Description");
		
		//When
		Mockito.when(medicationRepository.save(medication)).thenReturn(medication); //if Make this (medicationRepository.save()) call and return (medication)
		
		//Then
		assertThat(medicationService.addMedication(medication)).isEqualTo(medication);
	}
	
	@Test
	public void testUpdateMedication() {
		//Given
		Medication medication = new Medication();
		medication.setMedicationId(1L);
		medication.setMedicationName("Medication");
		medication.setDescription("Description");
					
		//When
		medication.setMedicationName("Paracetamol");
		Mockito.when(medicationRepository.save(medication)).thenReturn(medication);
		
		//Then
		assertThat(medicationService.updateMedication(1L, medication)).isEqualTo(medication);
	}
	
	@Test
	public void testDeleteMedication() {
		//Given
		Medication medication = new Medication();
		medication.setMedicationId(1L);
		medication.setMedicationName("Medication");
		medication.setDescription("Description");
		
		Mockito.when(medicationRepository.existsById(medication.getMedicationId())).thenReturn(false);
		
		assertFalse(medicationRepository.existsById(medication.getMedicationId()));
	}

	
}
