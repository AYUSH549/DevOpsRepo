package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.QuestionTypeDAO;
import com.example.demo.entities.QuestionTypeDTO;

@Component
public class DataService {
	
	@Autowired
	private QuestionTypeDAO questionTypeDao;
	
	@Transactional
	public List<QuestionTypeDTO> getData() {
		return questionTypeDao.getQuestionTypeData();
	}

}
