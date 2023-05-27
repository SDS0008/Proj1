  

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LogoutSer extends HttpServlet {

	  public void doGet(HttpServletRequest  req, HttpServletResponse  resp) throws ServletException,IOException
	  {
		    
		  
		       
			      HttpSession  hs= req.getSession();
				    
			      hs.invalidate();
			          

			       PrintWriter out=  resp.getWriter();
		      out.println("<html>");
		       
		          out.println("LOGOUT SUESSFULY...<br>");
		          
		          out.println ("<a href='login_pg.html'> click for login <a>");
		      out.println("</html>");
		     
	  }
}
