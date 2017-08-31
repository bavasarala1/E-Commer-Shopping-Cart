package girish.LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ResultSet;

import girish.modelBeans.ShoppingCart;

/**
 * Servlet implementation class Addtocart
 */
@WebServlet("/Addtocart")
public class Addtocart extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String order=" ";
		String actualorder=" ";
		String[] item={"","","",""};
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		item[0] = request.getParameter("item1");
		item[1] = request.getParameter("item2");
		item[2] = request.getParameter("item3");
		item[3]= request.getParameter("item4");
		ShoppingCart cart = new ShoppingCart();
		HttpSession session = request.getSession();
		if((session.getAttribute("currentSessionUser"))!= null)
		{
			int i;
			for(i=0;i<7;i++)
			{
				if(item[i] == null)
				{
					//out.print("Item"+i+" is null");
				}
				else
				{
					actualorder=actualorder+";"+item[i];
					try
					{
				            Class.forName("com.mysql.jdbc.Driver");
				            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject", "root", "root");
				            java.sql.Statement statement = null;
				            
				            statement = ((java.sql.Connection) conn).createStatement();
				            String QUERY = "SELECT * FROM inventory";
				            ResultSet rs = (ResultSet) statement.executeQuery(QUERY);
				            while(rs.next())
				            {
				            	if(item[i].equals(rs.getString("item_id")))
				            	{
				            	order= order +";"+rs.getString("item_name")+","+rs.getString("cost");
				            	}
				            }
				           					            	
				            	
				    }
				       catch (Exception e) 
				       {
				    	   
				            e.printStackTrace();
				       }

				}
			}
			HttpSession session1 = request.getSession();
			cart.setOrder(order);
			request.setAttribute("cart", cart);
			session1.setAttribute("order",actualorder);
			RequestDispatcher req = request.getRequestDispatcher("viewcart.jsp");
			req.forward(request, response); 
		}
		else
		{
				out.println("<script type=\"text/javascript\">");
				 out.println("location='login.jsp';");
			   out.println("alert('Please login and Shop Back');");
			   out.println("</script>");	
		}
		}

		
	}
