package com.cory.staff.service;

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
  
import com.cory.staff.bean.Staff; 
import com.cory.staff.service.DbConnection; 

public class StaffService {
	static HashMap<Integer,Staff> staffIdMap=getStaffIdMap();  
	  
	DbConnection Db = new DbConnection(); 
	
	 public StaffService() {  
	  super();  
	  
	  
	  
	  if(staffIdMap==null)  
	  {  
	   staffIdMap=new HashMap<Integer,Staff>();  
	  // Creating and initializing some Staff objects 
	  /* Staff HebruBrantley=new Staff(1, "Artist",100008785,"Hebru","Brantley","M");  
	   Staff JeanMichel=new Staff(4, "Artist",2000065246,"Jean","Basquiat","Michel");  
	   Staff MCEscher=new Staff(3, "Artist",1000567821,"M","Escher","C");  
	   Staff AndyWarhol=new Staff(2, "Artist",2000123401,"Andy","Warhol","M");  
	  
	  
	   staffIdMap.put(1,HebruBrantley);  
	   staffIdMap.put(4,JeanMichel);  
	   staffIdMap.put(3,MCEscher);  
	   staffIdMap.put(2,AndyWarhol);  */
	   //Db.connect(); 
	  }  
	 }  
	  
	 public List<Staff> getAllStaff()  
	 {  
	  List<Staff> staff = new ArrayList<Staff>(staffIdMap.values());  
	  return staff;  
	 }  
	  
	 public Staff getStaff(int id)  
	 {  
	  Staff staff = staffIdMap.get(id);  
	  return staff;  
	 }  
	 public Staff addStaff(Staff staff)  
	 {  
	  staff.setId(staffIdMap.size()+1);  
	  staffIdMap.put(staff.getId(), staff);  
	  return staff;  
	 }  
	   
	 public Staff updateStaff(Staff staff)  
	 {  
	  if(staff.getId()<=0)  
	   return null;  
	  staffIdMap.put(staff.getId(), staff);  
	  return staff;  
	  
	 }  
	 public void deleteStaff(int id)  
	 {  
	  staffIdMap.remove(id);  
	 }  
	  
	 public static HashMap<Integer, Staff> getStaffIdMap() {  
	  return staffIdMap;  
	 }  


	
}
