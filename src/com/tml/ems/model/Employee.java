package com.tml.ems.model;

/***
 * 
 * @author TML
 *
 */
public class Employee {

	private int id;
	private String name;
	private String location;
	private String email;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String name, String location, String email) {
		super();
		this.setId(id);
		this.setName(name);
		this.setLocation(location);
		this.setEmail(email);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", location="
				+ location + ", email=" + email + "]";
	}
	
}
