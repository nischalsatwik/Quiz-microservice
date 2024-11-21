package com.satwik.Quiz.Model;

public class Responsecheck {
	private Integer id;
	private String response;
	@Override
	public String toString() {
		return "Responsecheck [id=" + id + ", response=" + response + "]";
	}
	public Responsecheck()
	{
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Responsecheck(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	
}
