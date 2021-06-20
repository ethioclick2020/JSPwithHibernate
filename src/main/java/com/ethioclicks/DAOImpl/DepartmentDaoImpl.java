package com.ethioclicks.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ethioclicks.DAO.DepartmentDao;
import com.ethioclicks.entity.Department;
import com.ethioclicks.model.HibernateUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public void saveDepartment(Department department) {
		Session session = HibernateUtil.getSession();
		// Begin a unit of work and return the associated Transaction object.'
		Transaction transaction = session.beginTransaction();
		// Save to database
		session.save(department);
		// commit transaction
		transaction.commit();
		// End the session by releasing the JDBC connection and cleaning up
		session.close();
	}

	@Override
	public List<Department> showAllDepartments() {
		// Create list of department using ArrayList
		List<Department> listOfDepartment = new ArrayList<>();
		// Session
		Session session = HibernateUtil.getSession();
		// Begin a unit of work and return the associated Transaction object.
		Transaction transaction = session.beginTransaction();
		// HQL get student from database
		listOfDepartment = session.createQuery("FROM Department d").getResultList();
		// commit transaction
		transaction.commit();
		// End the session by releasing the JDBC connection and cleaning up
		session.close();

		return listOfDepartment;

	}

	public Department getDepartmentById(String id) {
		// Session
		Session session = HibernateUtil.getSession();
		// Begin a unit of work and return the associated Transaction object.
		Transaction transaction = session.beginTransaction();

		// HQL get student from database
		Department department = (Department) session.createQuery("FROM Department d WHERE id =:id").setString("id", id)
				.uniqueResult();
		// commit transaction
		transaction.commit();
		// End the session by releasing the JDBC connection and cleaning up
		session.close();

		return department;

	}

}
