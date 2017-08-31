package girish.LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user_id,pswd,pswd1,adres;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		user_id = request.getParameter("uid");
		pswd = request.getParameter("pwd");
		pswd1 = request.getParameter("pwd1");
		adres = request.getParameter("add");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			java.sql.Statement statement = null;
			statement = ((java.sql.Connection) conn).createStatement();
			String QUERY="insert into Register values('"+user_id+"','"+pswd+"','"+pswd1+"','"+adres+"')";
			int rs=statement.executeUpdate(QUERY);
			if(rs==1)
			{
				RequestDispatcher req = request.getRequestDispatcher("success.jsp");
				req.forward(request, response); 
				//out.println("alert('Regisration Success');");
				
			}
			/*else
			{
				RequestDispatcher req = request.getRequestDispatcher("success.jsp");
				req.forward(request, response); 
				out.println("alert('Regisration Failed');");
			}*/
		}
		catch (Exception e) 
	    {
			  e.printStackTrace();			
	    }
	}
}

