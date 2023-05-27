

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc_1.data;
import com.mvc_1.servlet_logic;


public class servlet_1 extends HttpServlet {
	
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
 String name =	req.getParameter("name");
 String user_name =	req.getParameter("user_name");
 
 String email=	req.getParameter("email");
 String password  =	req.getParameter("password");
 
 String contact =	req.getParameter("contact");
 String gender=	req.getParameter("gender");
 String lang =	req.getParameter("lang");
 String location =	req.getParameter("location");
	
 String file = req.getParameter("fle");
 
	
	
	
	data d = new data();
	
	d.setName(name);
	d.setUser_name(user_name);
	d.setEmail(email);
	d.setPassword(password);
	d.setContact(contact);
	d.setGender(gender);
	d.setLang(lang);
	d.setLocation(location);
	d.setfile(file);
	
	
	PrintWriter out = resp.getWriter();
	
	out.println(email);
	out.println(password);
	out.println(user_name);
	out.println(contact);
	out.println(location);
			
	
	servlet_logic ss = new servlet_logic();
	int r = ss.reg_1(d);
	

	out.println("update"+r);
	
	}

}
