package net.codejava.javaee.bookstore;
 
public class Book 
{
    protected int id;
    protected String title;
    protected String author;
  
    protected String stat;
 
    public Book() 
    {
    }
 
    public Book(int id)
    {
        this.id = id;
    }
 
    public Book(int id, String title, String author,  String stat) 
    {
        this(title, author,  stat);
        this.id = id;
    }
     
    public Book(String title, String author, String stat) 
    {
        this.title = title;
        this.author = author;
      
        this.stat = stat;
    }
 
    public int getId()
    {
        return id;
    }
 
    public void setId(int id)
    {
        this.id = id;
    }
 
    public String getTitle() 
    {
        return title;
    }
 
    public void setTitle(String title) 
    {
        this.title = title;
    }
 
    public String getAuthor() 
    {
        return author;
    }
 
    public void setAuthor(String author) 
    {
        this.author = author;
    }
 
    
    public String getStat()
    {
    	return stat;
    }
    
    public void setStat(String stat)
    {
    	this.stat = stat;
    }
    
    
}