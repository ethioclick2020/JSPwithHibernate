package com.ethioclicks.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ethioclicks.entity.StudentInfo;


public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
            //Create list of student using ArrayList
			List<StudentInfo> listOfStudent = new ArrayList<>();
			//Hibernate Configuration
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
            //Start session
			Session session = conf.buildSessionFactory().openSession();
			// Begin a unit of work and return the associated Transaction object.
			Transaction transaction = session.beginTransaction();
			//Get user input from TextField
			String tfSearch = request.getParameter("searchTxt");
			//HQL select all user from database
			String query = "FROM StudentInfo as si";
			listOfStudent = (List<StudentInfo>) session.createQuery(query).getResultList(); ;
			if (tfSearch != null)
			{
			    //HQL select all where FirstName = user input
				String query2 = "FROM StudentInfo as si WHERE si.firstName like :searchField";
				listOfStudent = (List<StudentInfo>) session.createQuery(query2).setString("searchField", "%" + tfSearch + "%").getResultList(); 

			}
			
			// commit transaction
			transaction.commit();
			// End the session by releasing the JDBC connection and cleaning up
			session.close();
           
			request.getSession().setAttribute("List", listOfStudent);
			response.sendRedirect("Search.jsp");
			
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Done");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
