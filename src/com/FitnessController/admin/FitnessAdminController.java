package com.FitnessController.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FitnessAdminController {


	@RequestMapping(value = "/welcome")
	public String welcomeDef(){
		System.out.println("*** adminIndex**");
		return "welcomeDef";
	}
	
	@RequestMapping(value = "/Adminshop")
	public String shopDef(){
		System.out.println("*** shopDef**");
		return "shopDef";
	}

	@RequestMapping(value = "/Adminschedule")
	public String scheduleDef(){
		System.out.println("*** scheduleDef**");
		return "scheduleDef";
	}
	
	@RequestMapping(value = "/Addtrainer")
	public String trainerDef(){
		System.out.println("*** trainerDef**");
		return "trainerDef";
	}
	
}
