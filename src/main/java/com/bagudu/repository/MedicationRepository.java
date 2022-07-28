package com.bagudu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.bagudu.model.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
