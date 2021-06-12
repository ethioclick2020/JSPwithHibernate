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

import com.ethioclicks.entity.UserInfo;

/**
 * Servlet implementation class Register
 */
//@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			System.out.println("Working");
			UserInfo user = new UserInfo();
			Date date = new Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			String fname = request.getParameter("fname");
			user.setFirstName(fname);
			String lname = request.getParameter("lname");
			user.setLastName(lname);
			String email = request.getParameter("email");
			user.setEmail(email);
			request.getSession().setAttribute("uname",email);
			String pw = request.getParameter("password");
			user.setPassword(pw);
			//set the value of timeStamp
			user.setTimeStamp(timeStamp);

			//Config
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");

			Session session = conf.buildSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			//Save to DB
			session.save(user);
			
			transaction.commit();
			session.close();

			System.out.println("Done");
			
			request.getSession().setAttribute("uname",email);
   		    response.sendRedirect("Home.jsp");
		}catch(Exception e){
			out.println("Error: "+e.getMessage());
		}
		
	}

}
