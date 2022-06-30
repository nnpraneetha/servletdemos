package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	public void init() {
		System.out.println("initializing addServlet...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","Pandu$01");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside post method.");
		String firstname=request.getParameter("fname");
		String lastname=request.getParameter("lname");
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");

		try {
			Statement st=con.createStatement();
			int result=st.executeUpdate("insert into user values('"+firstname+"','"+lastname+"','"+email+"','"+password+"')");
			PrintWriter out=response.getWriter();
			if(result>0) {
				out.println("<h1>User Created</h1>");
			}else {
				out.println("<h1>Error creating the user</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		
			try {
				if(con!=null) {
				con.close();
				}
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
}
