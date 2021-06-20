package com.ethioclicks.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ethioclicks.DAO.StudentDao;
import com.ethioclicks.entity.Department;
import com.ethioclicks.entity.StudentInfo;
import com.ethioclicks.model.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void saveStudent(StudentInfo student) {
		    Session session = HibernateUtil.getSession();
		    //Begin a unit of work and return the associated Transaction object.
		    Transaction transaction = session.beginTransaction();
		    //Save to database
		    session.save(student);
		    //commit transaction
	        transaction.commit();
	        //End the session by releasing the JDBC connection and cleaning up
	        session.close();
	}
	
	@Override
	public List<StudentInfo> showAllStudents() {
		//Create list of student using ArrayList
		List<StudentInfo> listOfStudent = new ArrayList<>();
		//Session
		Session session = HibernateUtil.getSession();
		//Begin a unit of work and return the associated Transaction object.
		Transaction transaction = session.beginTransaction();
     	//HQL get student from database 
     	listOfStudent = session.createQuery("FROM StudentInfo si JOIN fetch si.department").getResultList();
     	//commit transaction
		transaction.commit();
		//End the session by releasing the JDBC connection and cleaning up
		session.close();
		
        return listOfStudent;
	}

	@Override
	public long countStudent() {
		Session session = HibernateUtil.getSession();
    	Transaction transaction = session.beginTransaction();
    	long count = (long) session.createQuery("SELECT COUNT(si) FROM StudentInfo si").getSingleResult();
    	transaction.commit();
    	session.close();
		return count;
	}


}
