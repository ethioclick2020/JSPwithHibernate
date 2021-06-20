package com.ethioclicks.DAO;

import java.util.List;

import com.ethioclicks.entity.Department;

public interface DepartmentDao {
	
	public void saveDepartment (Department dept);
	public List<Department> showAllDepartments();
	public Department getDepartmentById(String id);

}
