<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>NewBookValenzuela</title>
</head>
<body>

<div class = lahat>
    <center>
        <h1>Valenzuela Library</h1>
        <h2>
           <!--    <a href="/Bookstore/valnew">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Bookstore/valenzuela">List All Books</a>-->
             Add New Book
        </h2>
    </center>
    
    <div align="center">
    	
        <c:if test="${book != null}">
            <form action="updateval" method="post">
        </c:if>
        <c:if test="${book == null}">
            <form action="insertval" method="post">
        </c:if>
        
        <table border="1" cellpadding="5">
        
            <caption>
                <h2>
                    <c:if test="${book != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${book == null}">
                        
                    </c:if>
                </h2>
            </caption>
            
                <c:if test="${book != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                </c:if>  
                         
            <tr>
                <th>Title: </th>
                <td>
                    <input required type="text" name="title" size="45"
                            value="<c:out value='${book.title}' />"
                        />
                </td>
            </tr>
            
            <tr>
                <th>Author: </th>
                <td>
                    <input required type="text" name="author" size="45"
                            value="<c:out value='${book.author}' />"
                    />
                </td>
            </tr>
            
          
            
              <tr>
            <th>Status: </th>
            <td>
            	<p><select name = "stat"  required></p>
            	<option value = "">--Select Status--</option>
            	<option value="Available">Available</option>
				<option value="Borrowed">Borrowed</option>
				
			</select>
            
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                 <a  href="/Bookstore/valenzuela">
                 		<img id = back src="https://www.pngrepo.com/png/247754/512/left-arrow-back.png">
                 </a>
                    <input id = save type="submit" value="Save" />
                   
                </td>
                
            </tr>
            
        </table>
        
        </form>
    
    </div>   
 </div>   
</body>

</html>


<style>
body
{

	background-image:url("https://images.unsplash.com/photo-1507842217343-583bb7270b66?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8bGlicmFyeXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80")

}

.lahat
{
	border-style:solid;
	
	background-color: rgba(255,255,255,0.7);
	width:55%;
	margin:auto;
	margin-top:5%;

}

table
{
	background-image:url("https://www.cssauthor.com/wp-content/uploads/2015/01/Wood-Texture.jpg");
	color: white;

	
	

	
}

th
{
	text-shadow: 2px 2px black;
}

h1
{
	font-family: Arial, Helvetica, sans-serif;
	 font-size:50px;

}



#back
{
	height:25px;
	width: 25px;
	flex: 0 0 47.5%;
	margin-right:75%;
	padding-top: 0px;	
	padding-bottom: 0px;	
	

}

#save
{

}

	}

</style>





















