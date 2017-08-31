
<%@page import="girish.modelBeans.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
				<%
				ShoppingCart cart = (ShoppingCart)request.getAttribute("cart");
				String order =cart.getOrder();
				String[] cartview = order.split(";");
				int i;
				out.print("<table align=\"center\" padding=\"2px\">");
				out.print("<tr>");
				out.print("<th>ItemName</th>");
				out.print("<th>Cost</th>");
				out.print("</tr>");
				for(i=1;i<cartview.length;i++)
				{
					String[] values= cartview[i].split(",");
					out.print("<tr>");
					out.print("<th>"+values[0]+"</th>");
					out.print("<th>"+values[1]+"</th>");
					out.print("</tr>");	
				}
				out.print("</table>");
				%>
				<a href="http://localhost:8080/GTimes/Checkout">Checkout</a>
</body>
</html>
		
		
		
		