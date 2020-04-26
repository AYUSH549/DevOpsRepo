package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.QuestionListDAO;
import com.example.demo.dao.QuestionTypeDAO;
import com.example.demo.entities.QuestionListDTO;
import com.example.demo.entities.QuestionTypeDTO;

@Component
public class DataService {
	
	@Autowired
	private QuestionTypeDAO questionTypeDao;
	
	@Autowired
	private QuestionListDAO questionListDao;
	
	@Transactional
	public List<QuestionTypeDTO> getData() {
		return questionTypeDao.getQuestionTypeData();
	}
	
	@Transactional
	public List<QuestionListDTO> getList(int qid) {
		return questionListDao.getAllData(qid );
	}

}
