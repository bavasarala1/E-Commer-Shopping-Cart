package girish.LoginServlet;

import girish.modelBeans.UsersDB;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String user_id,pswd;
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			user_id = request.getParameter("uid");
			pswd = request.getParameter("pwd");
			//HttpSession session = request.getSession(true);
			LCheck k = new LCheck();
			
			int val = k.checkLogin(user_id, pswd);
			
			if(val == 3)
			{
				UsersDB user  = new UsersDB();
				user =k.getUser(user_id, pswd);
				request.setAttribute("loguser", user);
				// session.setAttribute("currentSessionUser",user);
			RequestDispatcher req = request.getRequestDispatcher("success.jsp");
			req.forward(request, response);
			}
			else
			{
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert('User or password incorrect');");
				   out.println("location='Login.jsp';");
				   out.println("</script>");	
			}
	}

}
