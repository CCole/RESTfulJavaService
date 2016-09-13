/**
 * 
 */
package com.cory.staff.bean;

//import java.io.Serializable;

/**
 * @author coryp_000
 *
 */
public class Staff {

	/**
	 * 
	 */
	
	int id; 
	String staffType;
	long npiNumber;
	String firstName;
	String lastName;
	String middleName;
	
	public Staff() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Staff(int i, String staffType, long npiNumber, String firstName, String lastName, String middleName) {
		super();
		this.id = i;
		this.staffType = staffType;
		this.npiNumber = npiNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStaffType() {
		return staffType;
	}
	
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	
	public long getNpiNumber() {
		return npiNumber;
	}
	
	public void setNpiNumber(long npiNumber) {
		this.npiNumber = npiNumber;
	}
	
	public String getFirstName (){
		return firstName;
	}
	
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName () {
		return lastName;
	}
	
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	
	public String getMiddleName () {
		return middleName;
	}
	
	public void setMiddleName (String middleName) {
		this.middleName = middleName ;
	}

}
