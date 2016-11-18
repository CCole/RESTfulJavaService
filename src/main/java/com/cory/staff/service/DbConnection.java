package com.cory.staff.service;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.microsoft.sqlserver.jdbc.*;

import com.cory.staff.bean.Staff;

public class DbConnection {
	
	HashMap<String, Object> row = new HashMap<String, Object>(); 
	ArrayList<HashMap<String, Object>> table = new ArrayList<HashMap<String, Object>>();
	
	Connection conn = null ;
	Statement stmt = null; 
	ResultSet rs = null ;
	ResultSetMetaData rsmd = null ;
	
	String connURL = "jdbc:sqlserver://localhost:51041;databaseName=SQUIRE_NP;integratedSecurity=true;"; 
	
	
	
	public ArrayList<HashMap<String, Object>> connect(){
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(connURL);
			String sampleSQL = "SELECT TOP 10 * FROM dbo.Staff";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sampleSQL);
			
			//ResultSetMetaData rsmd = rs.getMetaData(); 
			
			System.out.print(rs);
			
			rsmd = rs.getMetaData(); 
			int cCount = rsmd.getColumnCount();
			
			while (rs.next()){
				//For each column get the value of the column in the current row
				for(int i = 1; i <= cCount; i++){
					
					row.put(rsmd.getColumnName(i), rs.getObject(i));
					table.add(row); //give me an arraylist of Hashmaps that represent records in my staff table
				}
				/*long NPI_Number = rs.getLong("NPI_Number");
				String Staff_Type = rs.getString("Staff_Type"); 
				String First_Name = rs.getString("First_Name");
				String Middle_Name = rs.getString("Middle_Name");
				String Last_Name = rs.getString("Last_Name");
				Date DOB = rs.getDate("DOB");
				int SQUIRE_Staff_ID = rs.getInt("SQUIRE_Staff_ID");*/
				
				//System.out.println(rs.getString("Staff_Type"));
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
		
		return table ;
	}
	
}
