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
import com.ethioclicks.model.HibernateUtil;

public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
			List<StudentInfo> listOfStudent = new ArrayList<>();
			listOfStudent = studentDaoImpl.showAllStudents();

			// Get user input from TextField
			String tfSearch = request.getParameter("searchTxt");

			if (tfSearch != null) {
				// HQL select all where FirstName = user input
				String query2 = "FROM StudentInfo as si WHERE si.firstName like :searchField";
				listOfStudent = (List<StudentInfo>) HibernateUtil.getSession().createQuery(query2)
						        .setString("searchField", "%" + tfSearch + "%").getResultList();
			}

			request.getSession().setAttribute("List", listOfStudent);
			response.sendRedirect("Search.jsp");

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Done");
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
