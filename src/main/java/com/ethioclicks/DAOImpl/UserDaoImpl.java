package com.ethioclicks.DAOImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ethioclicks.DAO.UserDao;
import com.ethioclicks.entity.UserInfo;
import com.ethioclicks.model.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void saveUser(UserInfo user) {
		//Session
		Session session = HibernateUtil.getSession();
		//Begin a unit of work and return the associated Transaction object.
	    Transaction transaction = session.beginTransaction();
	    //Save to database
	    HibernateUtil.getSession().save(user);
	    //commit transaction
        transaction.commit();
        //End the session by releasing the JDBC connection and cleaning up
        session.close();
	}

	@Override
	public long countUser() {
		//Session
		Session session = HibernateUtil.getSession();
		//Begin a unit of work and return the associated Transaction object.
		Transaction transaction = HibernateUtil.getSession().beginTransaction();
		long count = (long) HibernateUtil.getSession().createQuery("SELECT COUNT(ui) FROM UserInfo ui").getSingleResult();
		//commit transaction
    	transaction.commit();
    	//End the session by releasing the JDBC connection and cleaning up
    	session.close();
    	
		return count;
	}

	
}
