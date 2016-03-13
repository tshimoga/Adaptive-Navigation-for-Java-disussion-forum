package com.main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHandler {
	
	static DatabaseAccess sql;

	static { 
		sql = new DatabaseAccess();
	}
	
	public ResultSet checkDatabaseHandler(String userName) {

		try {
			sql.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		try {
			return (ResultSet)sql.readLoginDataBase(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean insertDatabaseHandler(String firstName, String lastName, String email, String password) {
		try {
			sql.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			return sql.insertLoginDataBase(firstName,lastName,email,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
