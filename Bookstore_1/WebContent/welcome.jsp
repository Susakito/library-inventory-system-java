<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class = lahat>


<div class = choice>
<div id = val>
	<a href="/Bookstore/valenzuela">
		<img src="http://images.metronewscentral.net/R8iws9BMCEvalenzuela-city.jpg" alt="valenzuelal">
	
	</a></div>
<div id = man>

	<a href="/Bookstore/manila">
		<img src="https://assets2.rappler.com/612F469A6EA84F6BAE882D2B94A4B421/img/E08E135C0FD040968B02AC5478CB288A/manila-city-hall-20140829-1.jpg" alt="manila">
	</a></div>
</div>
   
</div>    
    
</body>
</html>

<style>

img {
  
height:300px;
width:400px;
}
body {
		background-image:url("https://i.imgur.com/bTojUGz.png");
		background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;
     	 
}




.choice 
{
	

	display: flex;
	width: 1100px;
	height: 500px;
	margin:auto;
	margin-top:10%;
	
	
}

#man
{
	margin:10px 10px 10px 10px;
	width:50%;
	height:90%;
	
	text-align:center;
	
	padding-top:10%;
	padding-left:7.5%;
	flex: 1;
}

#val
{
	/*margin:10px 10px 10px 10px;*/
	width:50%;
	height:90%;
	
	text-align:center;
	padding-top:10%;
	flex: 0 0 47.5%;

	
}




/*.lahat{
		
	    width: 70%;
		height: 700px;
		margin: auto;
		text-align: center;
		background-color: white;
		opacity: 70%;
		border-radius: 25px;
		padding-top:10px;  
		border-style:solid;
}

#val
{
	border-style:solid;
	border-color:red;
}
#man
{
	border-style:solid;
	border-color:blue;
}*/



</style>