package services;

import java.sql.Connection;
import java.sql.DriverManager;

import domain.Book;

public class BookStoreService {

	public void persistObjectGraph(Book book) {
		
		private Connection con;
		
		try {
			
			Class.forName("com.mysql.jb.driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","Pandu$01");
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
