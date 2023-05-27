

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc_1.data;
import com.mvc_1.servlet_logic;



public class servlet_5 extends HttpServlet {
	
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	
	String email=req.getParameter("email");

	
	
	data d4 = new data();
	d4.setEmail(email);
	
	
	
	PrintWriter out = resp.getWriter();
	
	
	out.println(email +" : This email data is DELETED...");
			

	
	servlet_logic ss4 = new servlet_logic();
	int r3 = ss4.delete_1(d4);
	

	out.println("update : "+ r3);
}


}



