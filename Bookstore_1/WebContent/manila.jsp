<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html>
<head>
    <title>ManilaLibrary</title>
</head>
<body>
<%String type = String.valueOf(session.getAttribute("usertype"));%>


  
<div class = lahat>
	
    <center>
        <h1>Manila Library Books</h1>
        <h2>
         <%if (type   == "admin") 
                  {%>
        <div id = addnew>
           
                  		
 						<a href="/Bookstore/mannew">Add New Book</a>   
 						
                      
            &nbsp;&nbsp;&nbsp;
          <!--    <a href="/Bookstore/manila">List All Books</a>-->
             </div> <% }%>
             
        </h2>
        <br>
        <a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
        
    </center>
    
    <div align="center">
    
        <table border="1" cellpadding="5">
        
            <caption><h2>List of Books</h2></caption>
            
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            
            <c:forEach var="book" items="${listBook}">
     
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.stat}" /></td>
                    <td>
                    
                  <%if (type   == "admin") 
                  {%>
                  		 <a href="/Bookstore/editman?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Bookstore/deleteman?id=<c:out value='${book.id}' />">Delete</a>     
                      <% }
                      
                  else
                  {%>
                  	
                  
                	  <a href="/Bookstore/borrowman?id=<c:out value='${book.id}' />">Borrow</a>  
                 <%  
                  	}%>
                   
                                                
                                     
                    </td>
                </tr>
                
            </c:forEach>
            
        </table>
       </div>
        
     
    <div id = back>
    
    <form action="">
    	<a href="/Bookstore/welcome">BACK<a> 
	</form>

    
     
     
     
    </div>
    
    </div>
</body>
</html>

<style>
body
{
	background-image:url("https://assets2.rappler.com/612F469A6EA84F6BAE882D2B94A4B421/img/E08E135C0FD040968B02AC5478CB288A/manila-city-hall-20140829-1.jpg");
	background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
}


.lahat
{
	border-style:solid;
	
	background-color: rgba(255,255,255,0.7);
	width:55%;
	margin:auto;
	margin-top:5%;

}


h1
{
	 font-family: Arial, Helvetica, sans-serif;
	 font-size:50px;
}


 td
        {
            font-size: 15px;
            color: black;
           
        }


tr
{
	background-color:white;
	
}

tr:hover {background-color: #ddd;}

th {
  padding-top: 8px;
  padding-bottom: 8px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
  font-size:20px;
  }
  
/*a:hover, a:active 
{
	background-color: red;
}

a:link, a:visited 
	{
	  background-color: rgba(20,87,146);
	  padding: 5px 10px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  border-style: solid;
	  border-radius: 10px;
	  	
	}*/

#addnew 
{
  	  background-color: #4CAF50;
	  text-decoration: none;
	  display: inline-block;
	  border-style: solid;
	  border-radius: 10px;
	  padding-left:3.2%;
	  

}

#addnew a:hover, a:active
{
	background-color: white;
	border-radius:5px;
}

#back 
{
  	  background-color:#4CAF50;
	  padding-top:1%;
	  padding-bottom:.1%;
	  padding-left:2%;
	  padding-right:2%;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  border-style: solid;
	  border-radius: 10px;
	  margin:auto;
	  margin-left:10px;
	  margin-bottom:10px;
	  

}

#back a:hover, a:active
{
	background-color: white;
	border-radius:5px;
}










</style>