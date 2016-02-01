package com.tml.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tml.ems.model.Employee;
import com.tml.ems.util.DbUtil;

/***
 * 
 * @author TML
 *
 */
public class EmployeeDao {

	private Connection connection = null;;

	public EmployeeDao() {
		connection = DbUtil.getConnection();
	}
	
	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from employee");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String location = rs.getString("location");
				Employee employee = new Employee(id, name, location, email);
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}
	
	public Employee getEmployee(int id){
		
		Employee employee = null;
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from employee where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				String location = rs.getString("location");
				String email = rs.getString("email");
				employee = new Employee(id, name, location, email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}
	
	public boolean addEmployee(Employee employee){
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into employee(name, email, location) values (?, ?, ?)");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getLocation());
			int updatedrow = preparedStatement.executeUpdate();
			
			if(updatedrow > 0){
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void updateEmployee(Employee employee) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update employee set name=?, email=?, location=?" +
							"where id=?");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getLocation());
			preparedStatement.setInt(4, employee.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(int id) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from employee where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
