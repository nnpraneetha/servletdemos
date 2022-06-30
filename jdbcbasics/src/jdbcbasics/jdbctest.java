package jdbcbasics;

import java.sql.*;

public class jdbctest {
	public static void main(String[] args) {
		System.out.println("JDBC test");
	
		try (
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","Pandu$01");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from account");

				){
			
//			int result=st.executeUpdate("insert into account values(1,'praneetha','naradsau',2500)");
//			System.out.println("Values inserted successfully:"+result+" rows inserted");
//			st.executeUpdate("update account set balance=30000 where accno=2");
//			System.out.println("Successfully updated");
//			st.executeUpdate("delete from account where accno=2 ");
			System.out.println("AccNo firstname lastname amount");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"     "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
			
		
		
		
		
	}
}
