package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DatabaseAccess {
	private static final Logger LOG = Logger.getLogger(DatabaseAccess.class);
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	
	public void getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/adaptive_web?"
						+ "user=root&password=Universe123");
	}
	
	public ResultSet readLoginDataBase(String emailAddress){
		try {						
			preparedStatement = connect.prepareStatement("SELECT * FROM adaptive_web.USERS where EMAIL=?");    
			preparedStatement.setString(1, emailAddress);    
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet;

		} catch(Exception e){
			LOG.error("Issue while getting the login information "+e.getMessage());
		}
		return null;
	}

	public boolean insertLoginDataBase(String firstName, String lastName, String email, String password) {
		boolean flag = true;
		try{
			preparedStatement = connect
					.prepareStatement("INSERT into adaptive_web.USERS(FIRST_NAME,LAST_NAME,EMAIL,PASSWORD)VALUES(?,?,?,?); ");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.executeUpdate();
		}
		catch(Exception e){
			LOG.error("Issue while getting the login information "+e.getMessage());
			flag = false;
		}
		return flag;
	}
}
