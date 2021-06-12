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

public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			//Create list of user using ArrayList
			List<StudentInfo> listOfStudent = new ArrayList<>();
			//Hibernate Configuration
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			//Start session
			Session session = conf.buildSessionFactory().openSession();
			//Begin a unit of work and return the associated Transaction object.
			Transaction transaction = session.beginTransaction();
			//HQL get student from database 
			listOfStudent = session.createQuery("FROM StudentInfo").getResultList();
			//commit transaction
			transaction.commit();
			//End the session by releasing the JDBC connection and cleaning up
			session.close();
			
			System.out.println("Done");
			
			
			request.getSession().setAttribute("List", listOfStudent);
			response.sendRedirect("ViewStudent.jsp");
			
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
