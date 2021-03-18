package com.mps.think.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FollowUp {

	@RequestMapping(path="followUp")
	public String followUp(){
		return "followUp";
	}
}
