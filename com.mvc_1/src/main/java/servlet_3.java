

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc_1.servlet_logic;



public class servlet_3 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
		// TODO Auto-generated method stub
		
		
		String u_email = req.getParameter("email");
		String u_password = req.getParameter("password");
		
		
		servlet_logic ss3 = new servlet_logic();
		Vector v = ss3.fetch_1();
		
		
	PrintWriter out=resp.getWriter();
		
		if(v.contains(u_email) && v.contains(u_password))
		
		{
		
			HttpSession hs = req.getSession();
			hs.setAttribute("k1", u_email);
			hs.setAttribute("k2", u_password);
			
			
	RequestDispatcher	rd=	req.getRequestDispatcher("servlet_2");
			
			rd.forward(req,resp);
				
		}
		
		
		else 
		{				
			
		RequestDispatcher rd1 = req.getRequestDispatcher("login_pg.html");
		
		rd1.include(req,resp);
		out.println("LOGIN FAILS...");
		out.println("LOGIN FAILS...");
		out.println("LOGIN FAILS...");
		out.println("LOGIN FAILS...");
		out.println("LOGIN FAILS...");
		out.println("LOGIN FAILS...");
			
		}
		
		
	}


}
