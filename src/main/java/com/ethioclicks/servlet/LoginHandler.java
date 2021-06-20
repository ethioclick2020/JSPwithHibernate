package com.ethioclicks.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ethioclicks.entity.UserInfo;
import com.ethioclicks.model.HibernateUtil;

public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String userName = request.getParameter("email");
        String password = request.getParameter("pass");
        
        try {
        	UserInfo user = new UserInfo();
        	Session session = HibernateUtil.getSession();
        	Transaction transaction = session.beginTransaction();
        	user = (UserInfo) session.createQuery("FROM UserInfo u WHERE u.email =:Email and u.password =:Password").setString("Email", userName).setString("Password", password).uniqueResult();
        	 
        	transaction.commit();
        	session.close();
        	
        	
        	 if (user == null){
        		 response.sendRedirect("LoginError.jsp");
        	 }else{
        		 request.getSession().setAttribute("uname",userName);
        		 response.sendRedirect("Home.jsp");
        	 }
        	 
        	
        } catch (Exception e) {
            System.out.print("Error:" + e.getMessage());
        } 
	}

}
