

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc_1.data;
import com.mvc_1.servlet_logic;

//servlet_2 is a informaton or fetching data...

public class servlet_2 extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
	
		

		HttpSession hs = req.getSession(false);
		
		
		  if(hs!=null)
		  {
			  
				
				
				String u_email = (String) hs.getAttribute("k1");
				
				String u_password = (String) hs.getAttribute("k2");
				
		
			/*	
				PrintWriter out1 = resp.getWriter();
		
		  out1.println("session data :"+u_email);
		  out1.println("session data :"+u_password);
		  
	*/
				
		//reading ui data and forward to data class of setter methods...
	/*	
	String Email =req.getParameter("email");
		String Password = req.getParameter("password");
		*/
		
		
		//reading data values of setter methods...
		
		data d = new data();
		d.setEmail(u_email);
		d.setPassword(u_password);
		
		//write logics inside of service class..
		
	servlet_logic ss1 = new servlet_logic();
		
		Vector<data> v = ss1.log_1(d);
		
	
		
for(data d2 : v)// from data class with vector collection..
	
{
	

	    PrintWriter out = resp.getWriter();

	  out.println("<html>");
	    
	out.println("<table border=3>");

	out.println("<tr></br>");
	out.println(" <th>NAME</th>");
	out.println(" <th>USER_NAME</th>");
	
	out.println(" <th>EMAIL</th>");	
	out.println(" <th>PASSWORD</th>");

	out.println(" <th>CONTACT</th>");
	out.println(" <th>GENDER</th>");
	out.println(" <th>LANG</th>");
	out.println(" <th>LOCATION</th>");
	out.println(" <th>fle</th>");
	
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>"+d2.getName()+"</td>");
	
	out.println("<td>"+d2.getUser_name()+"</td>");
	
	out.println("<td>"+d2.getEmail()+"</td>");
	out.println("<td>"+d2.getPassword()+"</td>");
	out.println("<td>"+d2.getContact()+"</td>");
	out.println("<td>"+d2.getGender()+"</td>");
	out.println("<td>"+d2.getLang()+"</td>");
	out.println("<td>"+d2.getLocation()+"</td>");
	out.println("<td>"+d2.getfile()+"</td>");
	
	out.println("</tr>");

	out.println("</table>");
	
	out.println("</html>");
	
	// from hre .. link with logout servlet
	 RequestDispatcher  rd= req.getRequestDispatcher("LogoutSer");
	  
	    rd.include(req, resp);
	}
	

		  }// closing if
		  else
		  {
			  
			  
			  
	          PrintWriter out = resp.getWriter();
	          out.println("<html>");

			  out.println("U r DONGA.. plze login first");
		     
			 
			  out.println("</html>");
			  
			  

			  // link to login html
			  RequestDispatcher  rd= req.getRequestDispatcher("login_pg.html");
	          rd.include(req, resp);
	           
	         
						
		  }

}

}
	
	

