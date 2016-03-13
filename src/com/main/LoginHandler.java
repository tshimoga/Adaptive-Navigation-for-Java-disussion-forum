package com.main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginHandler {
	
	public static boolean checkRecords(String emailAddress,String password){
		ResultSet rs = null;
		String pass = "";
		try {
			DatabaseHandler handler = new DatabaseHandler();
			rs = handler.checkDatabaseHandler(emailAddress);
			if(rs!=null){
				if(rs.next()){
					pass = rs.getString("PASSWORD");
					if(pass.equals(password))
						return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean insertRecords(String firstName, String lastName, String email, String password) {
		boolean flag = false;
		DatabaseHandler handler = new DatabaseHandler();
		flag = handler.insertDatabaseHandler(firstName,lastName,email,password);
		return flag;
	
	}

}
