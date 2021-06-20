package com.ethioclicks.servlet;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ethioclicks.DAO.UserDao;
import com.ethioclicks.DAOImpl.UserDaoImpl;
import com.ethioclicks.entity.UserInfo;


/**
 * Servlet implementation class Register
 */

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			UserInfo user = new UserInfo();
			UserDao userDao = new UserDaoImpl();
			Date date = new Date();
			Timestamp timeStamp = new Timestamp(date.getTime());
			String firstName = request.getParameter("fname");
			user.setFirstName(firstName);
			String lastName = request.getParameter("lname");
			user.setLastName(lastName);
			String email = request.getParameter("email");
			user.setEmail(email);
			request.getSession().setAttribute("uname",email);
			String password = request.getParameter("password");
			user.setPassword(password);
			//set the value of timeStamp
			user.setTimeStamp(timeStamp);

			//Save to DB
			userDao.saveUser(user);
				
			request.getSession().setAttribute("uname",email);
   		    response.sendRedirect("Home.jsp");
   		    
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
		
	}

}
