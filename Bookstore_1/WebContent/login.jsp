<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    </head>
    <body>
     
    <div id = lahat>
   <h1 id = yow>Login </h1>
        <form name="form" action="<%=request.getContextPath()%>/login" method="post"><!-- /LoginServlet -->
 
        <table align="center">
        <tr>
        <td>Username</td>
        <td><input type="text" name="username" /></td>
        </tr>
        <tr>
        <td>Password</td>
        <td><input type="password" name="password" /></td>
        </tr>
        <tr>
        <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
        </tr>
        <tr>
        <td></td>
        <td><input type="submit" value="Login"></input></td>
        </tr>
        </table>
        </form>
       </div>
    </body>
</html>


<style>
body
{
	background-image:url("https://image.freepik.com/free-vector/modern-futuristic-background-personalized-key-lock_36402-496.jpg");
	background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
}


#lahat
{

border-style:solid;
	
	background-color: rgba(255,255,255,0.7);
	width:25%;
	margin:auto;
	margin-top:15%;
	

}
#yow
{

 text-align: center;
 margin-top:5%;

}





</style>