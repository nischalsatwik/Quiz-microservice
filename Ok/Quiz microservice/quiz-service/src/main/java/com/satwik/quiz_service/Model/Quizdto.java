package com.satwik.quiz_service.Model;

public class Quizdto {
	private String categoryName;
	private Integer numQuestions;
	private String title;
	@Override
	public String toString() {
		return "Quizdto [categoryName=" + categoryName + ", numQuestions=" + numQuestions + ", title=" + title + "]";
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getNumQuestions() {
		return numQuestions;
	}
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Quizdto()
	{
		
	}
	
}
