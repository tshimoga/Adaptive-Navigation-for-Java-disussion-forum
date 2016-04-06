package com.main;

import java.util.List;

public class User {
	String userName;
	String password;
	List<Tag> interests;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Tag> getInterests() {
		return interests;
	}
	public void setInterests(List<Tag> interests) {
		this.interests = interests;
	}
}
