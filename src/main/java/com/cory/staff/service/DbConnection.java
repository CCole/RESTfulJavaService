package com.cory.staff.service;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

public class DbConnection {
	
	Connection conn = null ;
	Statement stmt = null; 
	ResultSet rs = null ;
	
	String connURL = "jdbc:sqlserver://localhost:51041;databaseName=SQUIRE_NP;integratedSecurity=true;"; 
	
	public void connect(){
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(connURL);
			String sampleSQL = "SELECT TOP 10 * FROM dbo.Staff";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sampleSQL);
			System.out.print(rs);
			
			while (rs.next()){
				//Replace this with function that adds items in result set to staffIdMap in StaffService
				System.out.println(rs.getString(4));
			}
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
		
		finally {
			if (rs != null) try {rs.close();} catch(Exception e){}
			if (stmt != null) try {stmt.close();} catch(Exception e){}
			if (conn != null) try {conn.close();} catch(Exception e){}
		}
	}
	
}
