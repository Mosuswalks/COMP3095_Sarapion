<<<<<<< HEAD
package utilities;
/****************************************************************************************************
* Description: DatabaseAccess - Example provides access to database
****************************************************************************************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;
import beans.User;

public class DatabaseAccess {
	
	  private static String username = "admin@domain.ca";
	  private static String password = "P@ssword1";
	  private static String database = "COMP3095";
	
	  private static Connection connect = null;
	  
	  public static Connection connectDataBase() throws Exception {
	    try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"?"+"user=admin&password=sarapion");
	      return connect;
	    } catch (Exception e) {
	      throw e;
	    } 
	    
	  }
	  
	  public static boolean validateUser(String username, String password) throws Exception {
		  
		  boolean isValidUser = false;
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
			  while(set.next()) {
				  isValidUser = true;
			  }
		  }
		  catch (Exception e){
			  throw e;
		  }
		  return isValidUser;
	  }
	  
	  public static boolean registerUser(HashMap<String, String> userCred)throws Exception {
		  try {
			  
			  // Get the connection for the database
			  Connection connection = connectDataBase();
			  
			  //Write the SQL Query
			  String registerQuery = "INSERT INTO users (firstname, lastname, email, address, password) VALUES (?,?,?,?,?)";
			  
			  // Set Parameters with PreparedStatement
			  java.sql.PreparedStatement statement = connection.prepareStatement(registerQuery);
			  statement.setString(1, userCred.get("fName"));
			  statement.setString(2, userCred.get("lName"));
			  statement.setString(3, userCred.get("email"));
			  statement.setString(4, userCred.get("addr"));
			  statement.setString(5, userCred.get("password"));
			  
			  // Execute Statement
			  statement.execute();
			  return true;
				
		  }
		  catch (Exception e){
			  throw e;
		  }
		  
	  }


	
=======
package utilities;
/****************************************************************************************************
* Description: DatabaseAccess - Example provides access to database
****************************************************************************************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

public class DatabaseAccess {
	
	  private static String username = "admin@domain.ca";
	  private static String password = "P@ssword1";
	  private static String database = "COMP3095";
	
	  private static Connection connect = null;
	  
	  public static Connection connectDataBase() throws Exception {
	    try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      // Setup the connection with the DB
	      connect = DriverManager
		          .getConnection("jdbc:mysql://localhost:3306/"+database+"?"
			              + "user=admin&password=sarapion");
	      return connect;
	    } catch (Exception e) {
	      throw e;
	    } 
	    
	  }
	  
	  public static ResultSet loginUser(String username, String password) throws Exception {
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
			  return statement.executeQuery();
				
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
			  String registerQuery = "INSERT INTO users (firstname, lastname, email, address, password) VALUES (?,?,?,?,?)";
			  
			  // Set Parameters with PreparedStatement
			  java.sql.PreparedStatement statement = connection.prepareStatement(registerQuery);
			  statement.setString(1, userCred.get("fName"));
			  statement.setString(2, userCred.get("lName"));
			  statement.setString(3, userCred.get("email"));
			  statement.setString(4, userCred.get("addr"));
			  statement.setString(5, userCred.get("password"));
			  
			  // Execute Statement
			  statement.execute();
			  return true;
				
		  }
		  catch (Exception e){
			  throw e;
		  }
		  
	  }


	
>>>>>>> c6252a8bd69186643dbea96adbd5867c0676b89d
}