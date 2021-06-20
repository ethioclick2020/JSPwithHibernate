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
import com.ethioclicks.DAOImpl.DepartmentDaoImpl;
import com.ethioclicks.entity.Department;


public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Department department = new Department();
			DepartmentDao departmentDao = new DepartmentDaoImpl();
			String dept = request.getParameter("dept");
			department.setDepartmentName(dept);
			Date date = new Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			department.setTimeStamp(timeStamp);
			//save to DB
			departmentDao.saveDepartment(department);
			
			response.sendRedirect("/HibernateExampleWithJSP/ViewDepartment");
   		    
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}

}
