package com.tml.ems.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tml.ems.dao.EmployeeDao;
import com.tml.ems.model.Employee;

/***
 * 
 * @author TML
 *
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------------- doGet -----------------");
		String action = request.getParameter("action");
		System.out.println(action); 
		
		String forwardPageURL = null; 
		
		if(action.equals("emplist")){
			forwardPageURL = "/list.jsp";
			EmployeeDao dao = new EmployeeDao();
			List<Employee> employees = dao.getEmployees();
			request.setAttribute("employees", employees);
		}
		if(action.equals("delete")){
			forwardPageURL = "/list.jsp";
			EmployeeDao dao = new EmployeeDao();
			
			int id = Integer.parseInt(request.getParameter("id"));
			dao.deleteEmployee(id);
			
			List<Employee> employees = dao.getEmployees();
			request.setAttribute("employees", employees);
		}
		if(action.equals("insert")){
			forwardPageURL = "/add.jsp";
			EmployeeDao dao = new EmployeeDao();
			List<Employee> employees = dao.getEmployees();
			request.setAttribute("employees", employees);
		}
		
		if(action.equals("edit")){
			forwardPageURL = "/add.jsp";
			EmployeeDao dao = new EmployeeDao();
			int id = Integer.parseInt(request.getParameter("id"));
			Employee employee = dao.getEmployee(id);
			request.setAttribute("employee", employee);
		}
		
		 RequestDispatcher view = request.getRequestDispatcher(forwardPageURL);
	     view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String location = request.getParameter("location");
		
		System.out.println("name : "+ name + " email : "+email + " location : "+location);
		EmployeeDao dao = new EmployeeDao();
		
		if(id == null || id == ""){
			Employee employee = new Employee(0, name, location, email);
			dao.addEmployee(employee);
		}else{
			Employee employee = new Employee(Integer.parseInt(id), name, location, email);
			dao.updateEmployee(employee);
		}
		 
		//set emp list 
		List<Employee> employees = dao.getEmployees();
		request.setAttribute("employees", employees);
		
		String forwardPageURL = "/list.jsp";
		RequestDispatcher view = request.getRequestDispatcher(forwardPageURL);
	    view.forward(request, response);
	}

}
