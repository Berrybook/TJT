package com.tjt.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping(value="posreg")
	public String PosReg(){
		 return "POS_REG";
	}
	
	
	
}
