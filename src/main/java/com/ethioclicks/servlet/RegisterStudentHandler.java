package com.ethioclicks.servlet;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ethioclicks.DAO.DepartmentDao;
import com.ethioclicks.DAO.StudentDao;
import com.ethioclicks.DAOImpl.DepartmentDaoImpl;
import com.ethioclicks.DAOImpl.StudentDaoImpl;
import com.ethioclicks.entity.Department;
import com.ethioclicks.entity.StudentInfo;
import com.ethioclicks.model.HibernateUtil;


/**
 * Servlet implementation class RegisterStudentHandler
 */


public class RegisterStudentHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			StudentInfo student = new StudentInfo();

			StudentDao studentDao = new StudentDaoImpl();
			
			Date date = new Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			String firstName = request.getParameter("firstname");
			student.setFirstName(firstName);
			String lastName = request.getParameter("lastname");
			student.setLastName(lastName);
			String gender = request.getParameter("gender");
			student.setGender(gender);			
			
			String deptId = request.getParameter("department");
			DepartmentDao departmentDao = new DepartmentDaoImpl();
			Department department = departmentDao.getDepartmentById(deptId);
			
			String batch = request.getParameter("batch");
			student.setBatch(batch);
			//TimeStamp
			student.setTimeStamp(timeStamp);

			//Save to DB
			student.setDepartment(department);
		 	
			studentDao.saveStudent(student);
			
			
			response.sendRedirect("/HibernateExampleWithJSP/ViewStudent");
			
		}catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}



}
