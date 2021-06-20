package com.ethioclicks.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ethioclicks.DAO.DepartmentDao;
import com.ethioclicks.DAOImpl.DepartmentDaoImpl;
import com.ethioclicks.DAOImpl.StudentDaoImpl;
import com.ethioclicks.entity.Department;
import com.ethioclicks.entity.StudentInfo;

/**
 * Servlet implementation class ViewDepartment
 */

public class ViewDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DepartmentDaoImpl departmentDaoImpl = new DepartmentDaoImpl();
		List<Department> listOfDepartment = new ArrayList<>();
		listOfDepartment = departmentDaoImpl.showAllDepartments();
		request.getSession().setAttribute("list", listOfDepartment);
		response.sendRedirect("RegisterStudent.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
