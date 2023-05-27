

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc_1.data;
import com.mvc_1.servlet_logic;


public class servlet_4 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=	req.getParameter("email");
		String password= req.getParameter("password");
		String contact = req.getParameter("contact");
		String  location =req.getParameter("location");
		
		
		data d3 = new data();
		d3.setEmail(email);
		d3.setPassword(password);
		d3.setContact(contact);
		d3.setLocation(location);
		
		PrintWriter out = resp.getWriter();
		
		out.println(email);
		out.println(password);
		out.println(contact);
		out.println(location);
		
		
		
		servlet_logic ss3 = new servlet_logic();
		int r2 = ss3.update_1(d3);
		

		out.println("update : "+r2);
	}

	

}
