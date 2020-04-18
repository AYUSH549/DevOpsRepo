package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/homePage")
public class TestController {
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String register() {

		JSONObject responseJson = new JSONObject();
		String a="Samsung";
		responseJson.put("messages", a);
		return responseJson.toString();
		
	}
		

}
