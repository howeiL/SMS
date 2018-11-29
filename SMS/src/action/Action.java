package action;

import dao.StudentDao;
import model.Student;

public class Action {

	public void add(Student s) throws Exception{
		
		StudentDao st = new StudentDao();
		
		st.add(s);
	}
	
	public void del (int id) throws Exception{
		
		
		StudentDao st  = new StudentDao();
		
		st.del(id);
	}
     public void update(Student s) throws Exception{
		
		StudentDao st = new StudentDao();
		
		st.update(s);
	}
     public Student get(int id) throws Exception{
    	 
    	 StudentDao st = new StudentDao();
 		
 		   return st.get(id);
     }
      public boolean isget(int id) throws Exception{
    	 
    	 StudentDao st = new StudentDao();
 		
 		   return st.isget(id);
     }
}
