package net.codejava.javaee.bookstore;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

//------------------------------------------------------
import java.io.*;
import java.net.MalformedURLException;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.*;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

public class BookDAO 
{
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public BookDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) 
    {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    public void connect() throws SQLException //from protected to publicl 
    {
        if (jdbcConnection == null || jdbcConnection.isClosed()) 
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) 
            {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException
    {
        if (jdbcConnection != null && !jdbcConnection.isClosed())
        {
            jdbcConnection.close();
        }
    }
     
    
    public boolean insertBookval(Book book) throws SQLException //insert para sa val
    {
        String sql = "INSERT INTO val (title, author, stat) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setString(3, book.getStat());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public boolean insertBookman(Book book) throws SQLException //insert para sa manila
    {
        String sql = "INSERT INTO man (title, author, stat) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setString(3, book.getStat());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    
    public List<Book> listAllBooksVal() throws SQLException //para sa valenzuela library
    {
        List<Book> listBook = new ArrayList<>();
         
        String sql = "SELECT * FROM VAL";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) 
        {
            int id = resultSet.getInt("book_id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String stat = resultSet.getString("stat");
             
            Book book = new Book(id, title, author, stat);
            listBook.add(book);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listBook;
    }
    
    public List<Book> listAllBooksMan() throws SQLException //para sa manila library
    {
        List<Book> listBook = new ArrayList<>();
         
        String sql = "SELECT * FROM MAN";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) 
        {
            int id = resultSet.getInt("book_id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String stat = resultSet.getString("stat");
             
            Book book = new Book(id, title, author, stat);
            listBook.add(book);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listBook;
    }
    
    public boolean borrowman(Book book) throws SQLException //borrow para sa manila
    {
        String sql = "UPDATE man SET stat = 'Borrowed' where book_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getId());
         
        boolean borman = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return borman;     
    }
    
    public boolean borrowval(Book book) throws SQLException //borrow para sa val
    {
        String sql = "UPDATE val SET stat = 'Borrowed' where book_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getId());
         
        boolean borval = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return borval;     
    }
    
    public boolean deleteBookval(Book book) throws SQLException //delete para sa valenzuela
    {
        String sql = "DELETE FROM val where book_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
    
    public boolean deleteBookman(Book book) throws SQLException //delete para sa manila
    {
        String sql = "DELETE FROM man where book_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    
    public boolean updateBookval(Book book) throws SQLException //update val
    {
        String sql = "UPDATE val SET title = ?, author = ?, stat = ?";
        sql += " WHERE book_id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setString(3, book.getStat());
        statement.setInt(4, book.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public boolean updateBookman(Book book) throws SQLException //update man
    {
        String sql = "UPDATE man SET title = ?, author = ?, stat = ?";
        sql += " WHERE book_id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setString(3, book.getStat());
        statement.setInt(4, book.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
     
    
    public Book getBookval(int id) throws SQLException// para makuha yung book ng val
    {
        Book book = null;
        String sql = "SELECT * FROM val WHERE book_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String stat = resultSet.getString("stat");
             
            book = new Book(id, title, author, stat);
        }
         
        resultSet.close();
        statement.close();
         
        return book;
    }
    
    public Book getBookman(int id) throws SQLException// para makuha yung book ng manila
    {
        Book book = null;
        String sql = "SELECT * FROM man WHERE book_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String stat = resultSet.getString("stat");
             
            book = new Book(id, title, author, stat);
        }
         
        resultSet.close();
        statement.close();
         
        return book;
    }
    
    
 
    
   
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
