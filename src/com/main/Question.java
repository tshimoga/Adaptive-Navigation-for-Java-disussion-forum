package com.main;

public class Question {
	private int id;
	private String title;
	private String content;
	private String code;
	private User askedBy;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User getAskedBy() {
		return askedBy;
	}
	public void setAskedBy(User askedBy) {
		this.askedBy = askedBy;
	}
}
