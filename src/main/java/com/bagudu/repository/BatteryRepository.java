package com.bagudu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bagudu.model.Battery;

public interface BatteryRepository extends JpaRepository<Battery, Long> {

}
