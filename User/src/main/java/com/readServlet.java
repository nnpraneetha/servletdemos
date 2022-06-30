package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/readServlet")
public class readServlet extends HttpServlet {
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
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get method...");
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from user");
			PrintWriter out=response.getWriter();
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>FirstName</th>");
			out.println("<th>LastName</th>");
			out.println("<th>Email</th>");
			out.println("</tr>");
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
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
