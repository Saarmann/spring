package com.knits.spring.common.utils;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProjectUtils {


	public static Connection createConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		 String userName = "root";
         String password = "tere";
         String url = "jdbc:mysql://localhost:3306/team_taskmanagement";
         Class.forName ("com.mysql.jdbc.Driver").newInstance ();
         return  DriverManager.getConnection (url, userName, password);
	}
	
	
	public static void closeConnection(Connection connection){
		
		 if (connection != null){
             try   {
            	 connection.close ();
                 System.out.println ("connection closed");
             }
             catch (Exception e) { 
            	e.printStackTrace();
            }
         }
	}
}
