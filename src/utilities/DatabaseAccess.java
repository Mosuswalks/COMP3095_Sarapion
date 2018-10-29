/******************************************************************************************************
 * Project: Sarapion
 * Assignment: 1
 * Author: Mohamed Abdi, Carol Hung, Kevin Ly, ZhiRun Yulu
 * Student Numbers: 100-649-804, 101-019-479, 101-082-639, 101-065-994
 * Date: October 28 2018
 * Description: This file contains the Database Access Objects and Methods for our application.

********************************************************************************************************/

package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

public class DatabaseAccess {
	
	  
	  private static String database = "COMP3095";
	
	  private static Connection connect = null;
	  
	  public static Connection connectDataBase() throws Exception {
	    try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"?"+"user=admin&password=sarapion&serverTimezone=UTC");
	      return connect;
	    } catch (Exception e) {
	      throw e;
	    } 
	    
	  }
	  
	  
	  public static String validateUser(String username, String password) throws Exception {
		 
		  try {
			  
			  // Get the connection for the database
			  Connection connection = connectDataBase();
			  
			  //Write the SQL Query
			  String loginQuery = "SELECT * FROM users WHERE email = ? AND password = ?";
			  
			  // Set Parameters with PreparedStatement
			  java.sql.PreparedStatement statement = connection.prepareStatement(loginQuery);
			  statement.setString(1, username);
			  statement.setString(2, password);
			  
			  // Execute Statement
			  ResultSet set = statement.executeQuery();
			  
			  if(set.next()) {
				  return set.getString(2);
			  }
			  return null;
		  }
		  catch (Exception e){
			  throw e;
		  }
	  }
	  
	  
	  public static boolean registerUser(HashMap<String, String> userCred)throws Exception {
		  try {
			  
			  // Get the connection for the database
			  Connection connection = connectDataBase();
			 			  
			  //Write the SQL Query
			  String registerQuery = "INSERT INTO users (firstname, lastname, email, address, role, password) VALUES (?,?,?,?,?,?)";
			  
			  // Set Parameters with PreparedStatement
			  java.sql.PreparedStatement statement = connection.prepareStatement(registerQuery);
			  statement.setString(1, userCred.get("fName"));
			  statement.setString(2, userCred.get("lName"));
			  statement.setString(3, userCred.get("email"));
			  statement.setString(4, userCred.get("addr"));
			  statement.setString(5, "user");
			  statement.setString(6, userCred.get("password"));
			  
			  // Execute Statement
			  statement.execute();
			  return true;
				
		  }
		  catch (Exception e){
			  throw e;
		  }
	  }
	  
	  public static boolean isUniqueUser(String username) throws Exception{
		  try {
			  Connection connection = connectDataBase();
			  
			  String uniqueQuery = "SELECT COUNT(*) FROM USERS WHERE email = (?)";
			  
			  java.sql.PreparedStatement statement = connection.prepareStatement(uniqueQuery);
			  statement.setString(1, username);
			  
			  
			  ResultSet set = statement.executeQuery();
			  
			  if(set.next()) {
				  if(Integer.parseInt(set.getString(1)) == 0) {
					  return true;
				  }
			  }
			  return false;
		  }
		  catch(Exception e) {
			  throw e;
		  }
	  }

}