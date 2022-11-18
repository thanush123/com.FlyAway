package com.FlyAway.phase2.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtill {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getMySqlConnection() throws Exception {
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sb006","root","thanush123");
		
	}
	
	public static void cleanUp(PreparedStatement st,Connection con) {
		try {
			if(st!=null)
				st.close();
			if(con!=null)
				con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void cleanUp(PreparedStatement st,Connection con,ResultSet rs) {
		try {
			if(st!=null)
				st.close();
			if(con!=null)
				con.close();
			if(rs!=null)
				rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
