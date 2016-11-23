package com.cory.staff.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;  

import javax.ws.rs.DELETE;  
import javax.ws.rs.GET;  
import javax.ws.rs.POST;  
import javax.ws.rs.PUT;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;  

import com.cory.staff.service.DbConnection;
//import com.cory.staff.bean.Staff;  
import com.cory.staff.service.StaffService;  

@Path("/staff")
public class StaffController {
	
	DbConnection Db = new DbConnection(); 
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<HashMap<String, Object>>  getStaff() {
		//List<Staff>listOfStaff = staffService.getAllStaff();
		//System.out.print(listOfStaff)
		//return listOfStaff;
		return Db.createRecordList();
		
	}

	@GET
	@Path("/{tst}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloPlainText(){
		return "Hello RESTful World";
	}
/*
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Staff getStaffById(@PathParam("id") int id){
		return staffService.getStaff(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Staff addStaff(Staff staff){
		return staffService.addStaff(staff);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Staff updateStaff(Staff staff){
		return staffService.updateStaff(staff);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStaff(@PathParam("id") int id){
		staffService.deleteStaff(id);
	}*/

}
