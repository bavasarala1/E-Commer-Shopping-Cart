package girish.LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			String uname =(String) session.getAttribute("currentSessionUser");
			String order =(String) session.getAttribute("order");
			try
			{
			 	Class.forName("com.mysql.jdbc.Driver");
	            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject", "root", "root");
	            java.sql.Statement statement = null;
	            
	            statement = ((java.sql.Connection) conn).createStatement();
	            String QUERY = "INSERT into orders VALUES('"+uname+"','"+order+"')";
	            int val = statement.executeUpdate(QUERY);
	            if(val == 1)
	            {  
	            	   out.println("<script type=\"text/javascript\">");
					   out.println("alert('Order Confirmed');");
					   out.println("location='menu.jsp';");
					   out.println("</script>");
			            
	            }
	            else
	            {
	            	   out.println("<script type=\"text/javascript\">");
					   out.println("alert('order failed');");
					   out.println("location='menu.jsp';");
					   out.println("</script>");
			           
			    }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	

}
