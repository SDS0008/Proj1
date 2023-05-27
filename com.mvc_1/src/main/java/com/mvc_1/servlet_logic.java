package com.mvc_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class servlet_logic<E> {

	public static Connection myconn()
	{
		Connection con=null;
		
		try {
		//conn logics...
		FileInputStream fi =new FileInputStream("C:\\Users\\SAYALA DIVYA SUMANTH\\eclipse-workspace\\com.mvc_1\\src\\main\\java\\com\\mvc_1\\jdbc.properties");
		
		Properties p = new Properties();
		p.load(fi);
		
		Class.forName(p.getProperty("jdbc.driver")).newInstance();
		
	 con =	DriverManager.getConnection(p.getProperty("jdbc.url"),p.getProperty("jdbc.username"),p.getProperty("jdbc.password"));
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return con;
	}

	//writing logics for data class of getter methods
	
	
	public int reg_1(data d)
	{
		
		int r = 0;
		try {
		
		
		Connection con = servlet_logic.myconn();
		
		System.out.println(con);
		
		PreparedStatement pst = con.prepareStatement("insert into data2 values(?,?,?,?,?,?,?,?,?)");
		
		pst.setString(1, d.getName());
		pst.setString(2, d.getUser_name());
		pst.setString(3, d.getEmail());
		pst.setString(4, d.getPassword());
		pst.setString(5, d.getContact());	
		pst.setString(6,d.getGender());
		pst.setString(7, d.getLang());
		pst.setString(8, d.getLocation());


		FileReader fr = new FileReader(d.getfile());

		pst.setCharacterStream(9, fr);

			//updation
			r = pst.executeUpdate();
		
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
				
	}
	
	public Vector<data> log_1(data d)
	{	
		Vector v = new Vector();
	try {
		
	//ui data...
		
		System.out.println(d.getEmail());
		System.out.println(d.getPassword());
		
		//db data ...
		
FileInputStream fi =new FileInputStream("C:\\Users\\SAYALA DIVYA SUMANTH\\eclipse-workspace\\com.mvc_1\\src\\main\\java\\com\\mvc_1\\jdbc.properties");
		
		Properties p = new Properties();
		p.load(fi);
		
		Class.forName(p.getProperty("jdbc.driver")).newInstance();
		
RowSetFactory rs = RowSetProvider.newFactory();
		JdbcRowSet jr = rs.createJdbcRowSet();
		
		jr.setUrl(p.getProperty("jdbc.url"));
jr.setUsername(p.getProperty("jdbc.username"));
jr.setPassword(p.getProperty("jdbc.password"));

jr.setCommand("select * from data2 where email=? and password=?");


//for passing values(ui values...)

jr.setString(1, d.getEmail());
jr.setString(2, d.getPassword());

jr.execute();
		


//getting data...

for(;jr.next();)
{
	
data d2 = new data();

d2.setName(jr.getString("name"));
d2.setUser_name(jr.getString("user_name"));

d2.setEmail(jr.getString("email"));
d2.setPassword(jr.getString("password"));
d2.setContact(jr.getString("contact"));
d2.setGender(jr.getString("gender"));
d2.setLang(jr.getString("lang"));
d2.setLocation(jr.getString("location"));


Reader r1 =jr.getCharacterStream("fle");

//read data from r1 like 0 to -1 format...
File f1 = new File("hello.txt");
FileOutputStream fo = new FileOutputStream(f1);
for(int in1; (in1=r1.read())!=-1;in1++)
{
	System.out.println((char) in1);
fo.write(in1);

}

d2.setfile(f1.getAbsolutePath());

v.add(d2);//storing all data d2 in vector v..
}

	}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	return v;
		
	}
	
	public Vector fetch_1()
	{
		
		Vector v = new Vector();
		
		try {
			
			
		FileInputStream fi =new FileInputStream("C:\\Users\\SAYALA DIVYA SUMANTH\\eclipse-workspace\\com.mvc_1\\src\\main\\java\\com\\mvc_1\\jdbc.properties");
				
				Properties p = new Properties();
				p.load(fi);
				
				Class.forName(p.getProperty("jdbc.driver")).newInstance();
				
		RowSetFactory rs = RowSetProvider.newFactory();
				JdbcRowSet jr = rs.createJdbcRowSet();
				
				jr.setUrl(p.getProperty("jdbc.url"));
		jr.setUsername(p.getProperty("jdbc.username"));
		jr.setPassword(p.getProperty("jdbc.password"));

		jr.setCommand("select email,password from data2");
		
		jr.execute();
		
		
		
		
		for(;jr.next();)
		{
			
		v.add(jr.getString("email"));
		v.add(jr.getString("password"));
			
			
		}
		

	}
	
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return v;
		
}

	public int update_1(data d3)
	{
		int r2=0;
		try {
			
			//conn
				Connection con = servlet_logic.myconn();
				
				System.out.println(con);
				
				PreparedStatement pst = con.prepareStatement("update data2 set password=?,contact=?,location=? where email=?");
			
				pst.setString(1, d3.getPassword());
				
				pst.setString(2, d3.getContact());
				
				pst.setString(3, d3.getLocation());
				
				pst.setString(4, d3.getEmail());
				
					//updation
				
					r2 = pst.executeUpdate();

			

			
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return r2;
		
	}

	public int delete_1(data d4)
	{

		int r3=0;
		try {
			
			//conn
				Connection con = servlet_logic.myconn();
				
				System.out.println(con);
				
				PreparedStatement pst = con.prepareStatement("delete from data2 where email=?");
			
				
				pst.setString(1, d4.getEmail());
				
					//updation
					r3 = pst.executeUpdate();

		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return r3;
		
		
	}
	
	
	
}
