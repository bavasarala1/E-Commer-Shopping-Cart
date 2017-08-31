package girish.LoginServlet;

import girish.modelBeans.UsersDB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;

public class LCheck 
{
	
	public LCheck() 
	{
		
		
	}
	
	public int checkLogin(String uname, String pwwd)
	{
		if(uname == null || uname.trim() =="" || pwwd == null || pwwd.trim() =="")
		{
			return 1; 
		}
		else
		{
			 try
				{
			            Class.forName("com.mysql.jdbc.Driver");
			            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			            java.sql.Statement statement = null;
			            statement = ((java.sql.Connection) conn).createStatement();
			            String QUERY = "SELECT * FROM login WHERE password='"+pwwd+"' AND uname='"+uname+"'";
			            ResultSet rs = statement.executeQuery(QUERY);
			            if(!rs.next())
			            {  
			            	System.out.println("no result sets");
			            	return 1;
			            	
			            }
			            else
			            {
			            	System.out.println("result sets");
			        		return 3;
					    }
			        		
						
			       }
			       catch (Exception e) 
			       {
			            e.printStackTrace();
			       }

		}
		
		return 3;
	}
	
	public UsersDB getUser(String un,String pd)
	{
		UsersDB user  = new UsersDB();
		user.setUname(un);
		user.setPwd(pd);
		return user;
	}

}
