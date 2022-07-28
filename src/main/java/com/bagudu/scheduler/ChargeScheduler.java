package com.bagudu.scheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bagudu.service.BatteryService;

@Component
public class ChargeScheduler {
	
	@Autowired
	private BatteryService batteryService;

	@Scheduled(cron = "0 */2 * * * *") //Every 2 minutes
    public void scheduleTask() {
    	Long rate = 2L;
    	batteryService.updateAllCharge(rate);
    }
    
}
