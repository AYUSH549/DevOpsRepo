package com.example.demo.entities;

public class QuestionListDTO {
	
	private int qid;
	private String questions;
	private String options;
	private String questionsUrl;
	private String answers;
	private String detailedAnswers;
	private String answerUrls;
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getQuestionsUrl() {
		return questionsUrl;
	}
	public void setQuestionsUrl(String questionsUrl) {
		this.questionsUrl = questionsUrl;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public String getDetailedAnswers() {
		return detailedAnswers;
	}
	public void setDetailedAnswers(String detailedAnswers) {
		this.detailedAnswers = detailedAnswers;
	}
	public String getAnswerUrls() {
		return answerUrls;
	}
	public void setAnswerUrls(String answerUrls) {
		this.answerUrls = answerUrls;
	}
	
	

}
