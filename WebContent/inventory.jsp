<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CART</title>
</head>
<body>
<form action="Addtocart" method="post">
<input type="checkbox" name="item1" value="201">
				<a href="#"><img src="images/report1.png" height="300" width="300" alt="img" /></a>
				<h1>Apple Tech</h1>
				<p>ID:201 <br> Cost: $200</p>
			</article>
			<article>
			<input type="checkbox" name="item2" value="202">
				<a href="#"><img src="images/report2.png" height="300" width="300" alt="img" /></a>
				<h1>Rolex Royal</h1>
				<p>ID:202 <br> Cost: $1200</p>
			</article>
			<article class="last-article">
			<input type="checkbox" name="item3" value="203">
				<a href="#"><img src="images/report3.png" height="300" width="300" alt="img" /></a>
				<h1>GT 300</h1>
				<p>ID:203 <br> Cost: $400</p>		
			</article>
			<article>
			<input type="checkbox" name="item4" value="204">
				<a href="#"><img src="images/report4.PNG" height="300" width="300" alt="img" /></a>
				<h1>Titan T400</h1>
				<p>ID:204 <br> Cost: $900</p>	
			</article>
			<input type="submit" value="Add to Cart">
</form>
</body>
</html>