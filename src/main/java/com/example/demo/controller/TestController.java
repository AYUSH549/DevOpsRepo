package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.Errors;
import com.example.demo.entities.QuestionListDTO;
import com.example.demo.entities.QuestionTypeDTO;
import com.example.demo.service.DataService;


@RestController
@RequestMapping(value = "/home")
public class TestController {
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value = "/getType", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getType() {

		JSONObject responseJson = new JSONObject();
		int errNum = Errors.UNKNOWN;
		
		List<QuestionTypeDTO> fetchDetails = dataService.getData();
		
		if (fetchDetails.isEmpty()) {

			responseJson.put("msgType", Errors.UNKNOWN);
			responseJson.put("Message", "Invalid Referral code");
			return responseJson.toString();
		}
		
		responseJson.put("msgType", "200");
		responseJson.put("message", "Successful!!!");
		responseJson.put("value", fetchDetails);
		return responseJson.toString();
		
	}
	
	@RequestMapping(value = "/getQuestionList", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String getQuestionList() {
		
		JSONObject responseJson = new JSONObject();
		int qid = Integer.parseInt(request.getParameter("qid"));
		
		
		if(qid == 0)
		{
			responseJson.put("msgType", Errors.UNKNOWN);
			responseJson.put("message", "Invalid Request");
			return responseJson.toString();
		}
		
		
		List<QuestionListDTO> fetchList = dataService.getList(qid);
		
		if (fetchList.isEmpty()) {

			responseJson.put("msgType", Errors.UNKNOWN);
			responseJson.put("Message", "Something Goes Wrong");
			return responseJson.toString();
		}
		
		responseJson.put("msgType", "200");
		responseJson.put("message", "Successful!!!");
		responseJson.put("value", fetchList);
		return responseJson.toString();
	} 
	
		

}
