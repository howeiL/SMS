package dao;

import java.sql.Connection;

import java.sql.DriverManager;

public class Connect {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/sms"; 
	private static final String USER="root";
	private static final String PASSWORD ="110110";
	
	private static Connection c  = null ; 
	
/*	static{
		
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	
	public static Connection getConnection() throws Exception{
		
		
		Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection(URL,USER,PASSWORD);

		
		return c ;
	}
}
