package net.codejava.javaee.bookstore;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

public class ControllerServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;
 
    public void init()
    {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
     
        bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getServletPath();
 
        try
        {
            switch (action) 
            {
       
            
            case "/valnew":
                showNewFormval(request, response); // new form para sa val
                break;
            case "/mannew":
                showNewFormman(request, response); // new form para sa val
                break;
           
            case "/insertval":						
                insertBookval(request, response);// insert para sa val
                break;
            case "/insertman":						
                insertBookman(request, response);// insert para sa val
                break;
            
            case "/deleteman":
                deleteBookman(request, response);// delete para sa manila
                break;
            case "/deleteval":
                deleteBookval(request, response);// delete para sa valenzuela
                break;
            
            case "/editval":
                showEditFormval(request, response);// edti sa val
                break;
            case "/editman":
                showEditFormman(request, response);// edti sa manila
                break;
            case "/valenzuela":
            	valenzuela(request, response);
            	break;
            case "/manila":
            	manila(request, response);
            	break;
            
            case "/updateval":
                updateBookval(request, response);//update val
                break;
            case "/updateman":
                updateBookman(request, response);//update val
                break;
             
            case"/borrowman":
	            borrowman(request,response);
	            break;
            case"/borrowval":
	            borrowval(request,response);
	            break;
                
           /* case"/pdfval":
            	pdfval(request,response);
           	break;*/
           	
            case"/welcome":
            	welcome(request, response);
                break;
             
            default:
            		login(request, response);
            		break;
          
            }
        } 
        catch (SQLException ex) 
        {
            throw new ServletException(ex);
        }
    }
    

   // public class LoginServlet extends HttpServlet {
    //	private static final long serialVersionUID = 1L;
    	 
    //	public LoginServlet() {
    //	}

    
private void login(HttpServletRequest request, HttpServletResponse response) // login screen
		throws SQLException, IOException, ServletException 
{
    
	String userName = request.getParameter("username");
    String password = request.getParameter("password");
   // String usertype = request.getParameter("usertype");
   
    
 
    LoginBean loginBean = new LoginBean();
 
    loginBean.setUserName(userName);
    loginBean.setPassword(password);
 
    LoginDao loginDao = new LoginDao();

    try
    {
        String userValidate = loginDao.authenticateUser(loginBean);
        
        if(userValidate.equals("admin"))
        {
        	 String usertype = "admin";
        	HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("admin", userName); //session.setAttribute("Admin", userName); //setting session attribute
            session.setAttribute("usertype", usertype);
            //request.setAttribute("admin", userName);//request.setAttribute("userName", userName);
           request.setAttribute("admin", userValidate);
           
			//Object usertype = null;
			//request.setAttribute("admin", usertype);
          //  request.setAttribute("admin", userValidate);
 
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        	
        }
        
        else if(userValidate.equals("guest"))
        	
        {
        	 String usertype = "guest";
        	HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("guest", userName); //setting session attribute
           // request.setAttribute("accname", userName);//request.setAttribute("userName", userName);
            session.setAttribute("usertype", usertype);
            //Object usertype;
			//request.setAttribute("guest", usertype);
            request.setAttribute("guest", userValidate);
 
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        	
        }
        
        else 
        {
            System.out.println("Error message = "+userValidate);
            request.setAttribute("errMessage", userValidate);
 
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        
    }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    
	//RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	//dispatcher.forward(request, response);
}
    

    
   
 private void welcome(HttpServletRequest request, HttpServletResponse response) //welcome page jsp
         throws SQLException, IOException, ServletException 
         {
	 		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
	 		dispatcher.forward(request, response);
         }
 
 private void valenzuela(HttpServletRequest request, HttpServletResponse response) //valenzuela list jsp
         throws SQLException, IOException, ServletException 
         {
			 List<Book> listBook = bookDAO.listAllBooksVal();
		     request.setAttribute("listBook", listBook);
		     RequestDispatcher dispatcher = request.getRequestDispatcher("valenzuela.jsp");
		     dispatcher.forward(request, response);
		 }
 
 private void manila(HttpServletRequest request, HttpServletResponse response) //manila list jsp
         throws SQLException, IOException, ServletException 
         {
			 List<Book> listBook = bookDAO.listAllBooksMan();
		     request.setAttribute("listBook", listBook);
		     RequestDispatcher dispatcher = request.getRequestDispatcher("manila.jsp");
		     dispatcher.forward(request, response);
		 }
    	
 
   
 
   
    
    private void showNewFormval(HttpServletRequest request, HttpServletResponse response) //new form para sa val
            throws ServletException, IOException 
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("valnew.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewFormman(HttpServletRequest request, HttpServletResponse response) //new form para sa val
            throws ServletException, IOException 
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("mannew.jsp");
        dispatcher.forward(request, response);
    }

   
    
    private void showEditFormval(HttpServletRequest request, HttpServletResponse response)//edit val
            throws SQLException, ServletException, IOException 
    {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDAO.getBookval(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("valnew.jsp");
        request.setAttribute("book", existingBook);
        dispatcher.forward(request, response);
 
    }
    
    private void showEditFormman(HttpServletRequest request, HttpServletResponse response)//edit manila
            throws SQLException, ServletException, IOException 
    {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDAO.getBookman(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("mannew.jsp");
        request.setAttribute("book", existingBook);
        dispatcher.forward(request, response);
 
    }
 
   
    
    private void insertBookval(HttpServletRequest request, HttpServletResponse response) //insert book para sa valenzuela
            throws SQLException, IOException 
    {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String stat = request.getParameter("stat");
 
        Book newBook = new Book(title, author, stat);
        bookDAO.insertBookval(newBook);
        response.sendRedirect("valenzuela");
    }
    
    private void insertBookman(HttpServletRequest request, HttpServletResponse response) //insert book para sa manila
            throws SQLException, IOException 
    {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String stat = request.getParameter("stat");
 
        Book newBook = new Book(title, author, stat);
        bookDAO.insertBookman(newBook);
        response.sendRedirect("manila");
    }
 
    
    
    private void updateBookval(HttpServletRequest request, HttpServletResponse response)//update val
            throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String stat = request.getParameter("stat");
 
        Book book = new Book(id, title, author, stat);
        bookDAO.updateBookval(book);
        response.sendRedirect("valenzuela");
    }
    
    private void updateBookman(HttpServletRequest request, HttpServletResponse response)//update manila
            throws SQLException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String stat = request.getParameter("stat");
 
        Book book = new Book(id, title, author, stat);
        bookDAO.updateBookman(book);
        response.sendRedirect("manila");
    }
    
    private void borrowman(HttpServletRequest request, HttpServletResponse response) //borrow para sa manila
            throws SQLException, IOException 
         {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 Book book = new Book(id);
         bookDAO.borrowman(book);
         response.sendRedirect("manila");
    	
         }
    
    private void borrowval(HttpServletRequest request, HttpServletResponse response) //borrow para sa val
            throws SQLException, IOException 
         {
    	 int id = Integer.parseInt(request.getParameter("id"));
    	 Book book = new Book(id);
         bookDAO.borrowval(book);
         response.sendRedirect("valenzuela");
    	
         }
 
   
    
    private void deleteBookval(HttpServletRequest request, HttpServletResponse response) //delete para sa valenzuela
            throws SQLException, IOException 
    {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Book book = new Book(id);
        bookDAO.deleteBookval(book);
        response.sendRedirect("valenzuela");
 
    }
    
    private void deleteBookman(HttpServletRequest request, HttpServletResponse response) //delete para sa manila
            throws SQLException, IOException 
    {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Book book = new Book(id);
        bookDAO.deleteBookman(book);
        response.sendRedirect("manila");
 
    }
    
    /*private void pdfval(HttpServletRequest request, HttpServletResponse response) //pdf val
    throws SQLException, IOException, ServletException 
    {
		GeneratePDFval test = new GeneratePDFval();
		test.main(null);
		//GeneratePDFval.main(new String[] {});
		RequestDispatcher dispatcher = request.getRequestDispatcher("valenzuela.jsp");
		dispatcher.forward(request, response);
    }*/
}