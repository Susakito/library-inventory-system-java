package net.codejava.javaee.bookstore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 

import net.codejava.javaee.bookstore.DBConnetion;
 
public class LoginDao {
 
public String authenticateUser(LoginBean loginBean)
{
    String userName = loginBean.getUserName();
    String password = loginBean.getPassword();
 
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    String userNameDB = "";
    String passwordDB = "";
    String roleDB = "";
 
    try
    {
        con = DBConnetion.getConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("select accname,accpass,acctype from accounts");
        //resultSet = statement.executeQuery("select username,password,role from users");
 
        while(resultSet.next())
        {
            userNameDB = resultSet.getString("accname");
            passwordDB = resultSet.getString("accpass");
            roleDB = resultSet.getString("acctype");
 
            if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("admin"))
            return "admin";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("guest"))
            return "guest";
           
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
}
}
