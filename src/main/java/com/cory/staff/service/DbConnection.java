package com.cory.staff.service;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.microsoft.sqlserver.jdbc.*;

import com.cory.staff.bean.Staff;

public class DbConnection {
	
	
	ArrayList<HashMap<String, Object>> table = new ArrayList<HashMap<String, Object>>();
	
	Connection conn = null ;
	Statement stmt = null; 
	ResultSet rs = null ;
	ResultSetMetaData rsmd = null ;
	
	String connURL = "jdbc:sqlserver://localhost:51041;databaseName=SQUIRE_NP;integratedSecurity=true;"; 
	
	public Connection connect(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(connURL);
			
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
		
		return conn ;
	}
	
	
	
	public ArrayList<HashMap<String, Object>> createRecordList(){
		
		try {
			conn = connect();
			String sampleSQL = "SELECT TOP 10 * FROM dbo.Staff";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sampleSQL);
			
			//ResultSetMetaData rsmd = rs.getMetaData(); 
			
			System.out.print(rs);
			
			rsmd = rs.getMetaData(); 
			int cCount = rsmd.getColumnCount();
			
			while (rs.next()){
				HashMap<String, Object> row = new HashMap<String, Object>(); 
				//For each column get the value of the column in the current row
				for(int i = 1; i <= cCount; i++){
					
					//System.out.println(rs.getString(i));
					row.put(rsmd.getColumnName(i), rs.getObject(i));
					
				}
				
				table.add(row); //give me an arraylist of Hashmaps that represent records in my staff table
				
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
