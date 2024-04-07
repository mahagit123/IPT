package org.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class Sample {
	public static void main(String[] args) {
		Connection con=null;
		
		// 1. Load the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.Connect to database
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Hr", "Darsh@2717");
		//3.Write SQL query
			String query="select * from student";
			//4.prepare the statement
			PreparedStatement ps=con.prepareStatement(query);
			//5.execute query
			ResultSet rs=ps.executeQuery();
			//6. Iterate the results
			while (rs.next()) {
				int stuID=rs.getInt("sid");
				System.out.println(stuID);
				String stuName=rs.getString("sname");
				System.out.println(stuName);
			}
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			//7.Close DB connection
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		

		

			
			}
}
