package com.ethioclicks.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ethioclicks.entity.StudentInfo;


/**
 * Servlet implementation class RegisterStudentHandler
 */
public class RegisterStudentHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			System.out.println("Working...");
			StudentInfo student = new StudentInfo();
			Date date = new Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			String fname = request.getParameter("firstname");
			student.setFirstName(fname);
			String lname = request.getParameter("lastname");
			student.setLastName(lname);
			String gender = request.getParameter("gender");
			student.setGender(gender);
			String dept = request.getParameter("department");
			student.setDepartment(dept);
			String batch = request.getParameter("batch");
			student.setBatch(batch);
			String desc = request.getParameter("description");
			student.setDescription(desc);
			//TimeStamp
			student.setTimeStamp(timeStamp);

			// Hibernate configuration
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");

			Session session = conf.buildSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			//Save to DB
			session.save(student);

			transaction.commit();
			session.close();

			System.out.println("Done");
			response.sendRedirect("/HibernateExampleWithJSP/ViewStudent");
			
		}catch(Exception e){
			out.println("Error: "+e.getMessage());
		}
	}

}
