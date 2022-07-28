package com.bagudu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.bagudu.model.Drone;

public interface DroneRepository extends JpaRepository<Drone, Long> {

}
