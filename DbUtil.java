package com.intellect.training.jdbc.sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			//loadng and registered with Drivermanager
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.print("\nmysql driver loaded..from line 16..");
			
			//creating connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stockmarket","root","San@root123!");
			//System.out.print("\nConnection created.. from line 18..");
		}catch(ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}catch(Exception e1){
			System.err.println(e1.getMessage());
		}
		return(con);
	}

}
