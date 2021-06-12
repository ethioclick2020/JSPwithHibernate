package com.ethioclicks.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ethioclicks.entity.UserInfo;


public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
        String uname = request.getParameter("email");
        String pw = request.getParameter("pass");
        
        try {
        	UserInfo user = new UserInfo();
        	Configuration conf = new Configuration();
        	conf.configure("hibernate.cfg.xml");
        	Session sesssion = conf.buildSessionFactory().openSession();
        	Transaction transaction = sesssion.beginTransaction();
        	user = (UserInfo) sesssion.createQuery("FROM UserInfo u WHERE u.email =:Email and u.password =:Password").setString("Email", uname).setString("Password", pw).uniqueResult();
        	 
        	transaction.commit();
        	sesssion.close();
        	
        	
        	 if (user == null){
        		 response.sendRedirect("LoginError.jsp");
        	 }else{
        		 request.getSession().setAttribute("uname",uname);
        		 response.sendRedirect("Home.jsp");
        	 }
        	 
        	
        } catch (Exception e) {
            out.print("Error:" + e.getMessage());
        } 
	}

}
