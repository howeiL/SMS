package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;



public class AccountDao {

	public static void add(String a ,String p) throws Exception{
		
		Connection conn = Connect.getConnection();
		
		String sql = " insert into user"
				+ " (account,password)"
				+" values"
				+" (?,?)";
		
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, a);
		ps.setString(2, p);
		
		ps.execute();
	}
	
    public static boolean ishave(String a ) throws Exception{
		
		Connection conn = Connect.getConnection();
		
		String sql = " select * from user"
				+ " where account=?";
		
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, a);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			
			return true;
		}else{
			
			return false;
		}
		
		
		
	}
	
	
	
    public  static boolean signIn(String a,String p) throws Exception {

    	Connection conn = Connect.getConnection();
    	
    	
    	
    	String sql = " select * from user"
				+ " where account=?";
    	PreparedStatement ps = conn.prepareStatement(sql);
    	
    	ps.setString(1, a);
    	
    	
    	
    	ResultSet rs = ps.executeQuery();
    
    	
    	while(rs.next()){
    		
    		if(p.equals(rs.getString("password"))){
    			
    			return true ;
    		}else{
    			
    			return false ;
    		}
    		
    	
    	}
    	
    	return false;
	}
    /*public static void main(String[] args) throws Exception {
		
    	System.out.println(signIn("howei2","1234"));
	}*/
   
}
