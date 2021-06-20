package com.ethioclicks.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ethioclicks.DAOImpl.StudentDaoImpl;
import com.ethioclicks.entity.StudentInfo;

public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		List<StudentInfo> listOfStudent = new ArrayList<>();
		listOfStudent = studentDaoImpl.showAllStudents();
		request.getSession().setAttribute("List", listOfStudent);
		response.sendRedirect("ViewStudent.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
