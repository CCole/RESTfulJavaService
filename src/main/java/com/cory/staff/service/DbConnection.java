package com.cory.staff.service;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.microsoft.sqlserver.jdbc.*;

import com.cory.staff.bean.Staff;

public class DbConnection {
	
	//chore: choose one
	ArrayList<HashMap<String, Object>> table = new ArrayList<HashMap<String, Object>>();
	ArrayList<Staff> sTable = new ArrayList<Staff>();
	//chore: choose one
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
	
	public Staff getRecordById(int id){
		Staff row = new Staff(); 
		
		try{
			conn = connect();
			String sql = "SELECT * FROM dbo.Staff WHERE dbo.Staff.SQUIRE_STAFF_ID=(?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			
			rsmd = rs.getMetaData(); 
			//int cCount = rsmd.getColumnCount();
			
			while (rs.next()){
				
				row.setId(rs.getInt("SQUIRE_STAFF_ID"));
				row.setStaffType(rs.getString("Staff_Type"));
				row.setNpiNumber(rs.getString("NPI_Number"));
				row.setFirstName(rs.getString("First_Name"));
				row.setMiddleName(rs.getString("Middle_Name"));
				row.setLastName(rs.getString("Last_Name"));
				
				
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
			if (rs != null) try {rs.close();} catch(Exception e){}
			if (stmt != null) try {stmt.close();} catch(Exception e){}
			if (conn != null) try {conn.close();} catch(Exception e){}
		}
		
		return row;
	}
	
	public int updateRecord(Staff staff){
		int rows = 0;
		
		try{
			conn = connect();
			String sql = "UPDATE dbo.Staff" +
					"SET dbo.Staff.Staff_Type=(?), dbo.Staff.NPI_Number=(?), dbo.Staff.First_Name=(?), "
					+ "dbo.Staff.Last_Name=(?), dbo.Staff.Middle_Name=(?)" + "WHERE dbo.Staff.SQUIRE_STAFF_ID=(?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(6, staff.getId());
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
		
		finally{
			if (rs != null) try {rs.close();} catch(Exception e){}
			if (stmt != null) try {stmt.close();} catch(Exception e){}
			if (conn != null) try {conn.close();} catch(Exception e){}
		}
		return rows ; 
	}
	
	public int addRecord(Staff staff){
		int rows = 0; 
		
		try {
			conn = connect();
			String sql = "INSERT INTO dbo.Staff"
					+ "(dbo.Staff.Staff_Type, dbo.Staff.NPI_Number, dbo.Staff.First_Name, dbo.Staff.Last_Name, dbo.Staff.Middle_Name) VALUES"
					+"(?,?,?,?,?)"; 
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, staff.getStaffType());
			psmt.setString(2, staff.getNpiNumber());
			psmt.setString(3, staff.getFirstName());
			psmt.setString(4, staff.getLastName());
			psmt.setString(5, staff.getMiddleName());
			
			rows = psmt.executeUpdate();
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
		
		finally{
			if (rs != null) try {rs.close();} catch(Exception e){}
			if (stmt != null) try {stmt.close();} catch(Exception e){}
			if (conn != null) try {conn.close();} catch(Exception e){}
		}
		
		return rows;
	}
	
	
	public ArrayList<HashMap<String, Object>> getRecordList(){
		
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
