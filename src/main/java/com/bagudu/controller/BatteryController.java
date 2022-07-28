package com.bagudu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bagudu.model.Battery;
import com.bagudu.service.BatteryService;

@RestController
public class BatteryController {
	
	@Autowired
	private BatteryService batteryService;
	
	 //register a Battery
    @RequestMapping(method=RequestMethod.POST, value="/battery/register")
    public Battery registerBattery(@RequestBody Battery battery) {
    	return batteryService.addBattery(battery);
    }

}
