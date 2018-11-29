package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

import javax.print.attribute.standard.PresentationDirection;


import model.Student;

public class StudentDao {

	
      public void add(Student s) throws Exception{
    	  
    	  Connection conn = Connect.getConnection();
    	  
    	  String sql = "insert into student"
    	  		+ "(id, name,sex,age,class)"
    	  		+ "values"
    	  		+ "(?,?,?,?,?)";
    	  

    	  PreparedStatement p =conn.prepareStatement(sql);
    	  p.setInt(1, s.getId());
    	  p.setString(2, s.getName());
    	  p.setString(3, s.getSex());
    	  p.setInt(4, s.getAge());
    	  p.setString(5, s.getClazz());
    	  p.execute();
    	  
    	  
    	  
    	  
      }
      public   List<Student> queryall() throws Exception{
    	  Connection conn = Connect.getConnection();
 	
    	  Statement s = conn.createStatement();
    	  
    	  String sql = "select * from student";
    	  
    	  ResultSet rs = s.executeQuery(sql);
    	  
    	  Student st =null;
    	  List<Student> list = new ArrayList<Student>();
    	  
    	  while(rs.next()){
    		  st =new Student();
    		  st.setAge(rs.getInt("age"));
    		  st.setClazz(rs.getString("class"));
    		  st.setId(rs.getInt("id"));
    		  st.setSex(rs.getString("sex"));
    		  st.setName(rs.getString("name"));
    		  
    		  list.add(st);
    	  }
    	  
    	  return list;
      }
      public void del(int id) throws Exception{
    	  
          Connection conn = Connect.getConnection();
    	  
          String sql ="delete  from student"+
        			" where id =?";
    	  

    	  PreparedStatement p =conn.prepareStatement(sql);
    	  
    	  p.setInt(1, id);
    	  p.execute();
    	  
    	  
    	  
    	  
      }
      public void update(Student s) throws Exception{
    	  
    	  Connection conn = Connect.getConnection();
    	  
    	  String sql ="update student set name=?,sex=?,age=?,class=? "
    	  		+ "where id = ?";
			  
    	  PreparedStatement p = conn.prepareStatement(sql);
    	  
    	  p.setString(1, s.getName());
    	  p.setString(2, s.getSex());
    	  p.setInt(3, s.getAge());
    	  p.setString(4, s.getClazz());
    	  p.setInt(5, s.getId());
    	  p.execute();
      }

      public static Student get(int id) throws Exception{
    	  
          Connection conn = Connect.getConnection();
    	  Student s =new Student();
          
          String sql =" select * from student"+
        			" where id =?";
    	  

          PreparedStatement ps =conn.prepareStatement(sql);
    	 
          ps.setInt(1, id);

    	 ResultSet rs =ps.executeQuery();
    	  
    	 while(rs.next()){
    	 s.setId(rs.getInt("id"));
    	 s.setClazz(rs.getString("class"));
    	 s.setAge(rs.getInt("age"));
    	 s.setName(rs.getString("name"));
    	 s.setSex(rs.getString("sex")); 	  
    	  
    	 }
    	  return s;
      }
      public static boolean  isget(int id) throws Exception{
    	  
          Connection conn = Connect.getConnection();
    	  Student s =new Student();
          
          String sql =" select * from student"+
        			" where id =?";
    	  

          PreparedStatement ps =conn.prepareStatement(sql);
    	 
          ps.setInt(1, id);
       
          ResultSet rs = ps.executeQuery();
 
    	if(rs.next()){
    		
    		return true;
    	}else{
    	  return false;
    	  }
      
      }
 

public static List<Student> queryId(int id) throws Exception{
    	  
          Connection conn = Connect.getConnection();
    	  Student s =null;
    	  List<Student> l = new ArrayList<Student>();
    	  
          String sql =" select * from student"+
        			" where id =?";
    	  

          PreparedStatement ps =conn.prepareStatement(sql);
    	 
          ps.setInt(1, id);

    	 ResultSet rs =ps.executeQuery();
    	  
    	 while(rs.next()){
    	
    	 s=new Student();
    	 s.setId(rs.getInt("id"));
    	 s.setClazz(rs.getString("class"));
    	 s.setAge(rs.getInt("age"));
    	 s.setName(rs.getString("name"));
    	 s.setSex(rs.getString("sex")); 	  
    	  
    	 l.add(s);
    	 } 
    	 return l;
}	 
public static List<Student> queryName(String name) throws Exception{
    	  
          Connection conn = Connect.getConnection();
    	  Student s =null;
    	  List<Student> l = new ArrayList<Student>();
    	  
          String sql =" select * from student"+
        			" where name =?";
    	  

          PreparedStatement ps =conn.prepareStatement(sql);
    	 
          ps.setString(1, name);

    	 ResultSet rs =ps.executeQuery();
    	  
    	 while(rs.next()){
    	
    	 s=new Student();
    	 s.setId(rs.getInt("id"));
    	 s.setClazz(rs.getString("class"));
    	 s.setAge(rs.getInt("age"));
    	 s.setName(rs.getString("name"));
    	 s.setSex(rs.getString("sex")); 	  
    	  
    	 l.add(s);
    	 } 
    	 return l;
}	 
    	 
    public static List<Student> querySex(String sex) throws Exception{
    	  
          Connection conn = Connect.getConnection();
    	  Student s =null;
    	  List<Student> l = new ArrayList<Student>();
    	  
          String sql =" select * from student"+
        			" where sex =?";
    	  

          PreparedStatement ps =conn.prepareStatement(sql);
    	 
          ps.setString(1, sex);

    	 ResultSet rs =ps.executeQuery();
    	  
    	 while(rs.next()){
    	
    	 s=new Student();
    	 s.setId(rs.getInt("id"));
    	 s.setClazz(rs.getString("class"));
    	 s.setAge(rs.getInt("age"));
    	 s.setName(rs.getString("name"));
    	 s.setSex(rs.getString("sex")); 	  
    	  
    	 l.add(s);
    	 }
    	
    	  return l;
      }
    public static List<Student> queryAge(int age) throws Exception{
  	  
        Connection conn = Connect.getConnection();
  	  Student s =null;
  	  List<Student> l = new ArrayList<Student>();
  	  
        String sql =" select * from student"+
      			" where age =?";
  	  

        PreparedStatement ps =conn.prepareStatement(sql);
  	 
        ps.setInt(1, age);

  	 ResultSet rs =ps.executeQuery();
  	  
  	 while(rs.next()){
  	
  	 s=new Student();
  	 s.setId(rs.getInt("id"));
  	 s.setClazz(rs.getString("class"));
  	 s.setAge(rs.getInt("age"));
  	 s.setName(rs.getString("name"));
  	 s.setSex(rs.getString("sex")); 	  
  	  
  	 l.add(s);
  	 }
  	
  	  return l;
    }
    public static List<Student> queryClass(String clazz) throws Exception{
  	  
        Connection conn = Connect.getConnection();
  	  Student s =null;
  	  List<Student> l = new ArrayList<Student>();
  	  
        String sql =" select * from student"+
      			" where class =?";
  	  

        PreparedStatement ps =conn.prepareStatement(sql);
  	 
        ps.setString(1, clazz);

  	 ResultSet rs =ps.executeQuery();
  	  
  	 while(rs.next()){
  	
  	 s=new Student();
  	 s.setId(rs.getInt("id"));
  	 s.setClazz(rs.getString("class"));
  	 s.setAge(rs.getInt("age"));
  	 s.setName(rs.getString("name"));
  	 s.setSex(rs.getString("sex")); 	  
  	  
  	 l.add(s);
  	 }
  	
  	  return l;
    }
    
    
      /* public static void main(String[] args) throws Exception {
		
    	  
    	  System.out.println(queryClass("Èí¼þ16071"));
	}*/
}
