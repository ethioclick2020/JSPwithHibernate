package com.ethioclicks.DAO;

import java.util.List;

import com.ethioclicks.entity.Department;
import com.ethioclicks.entity.StudentInfo;

public interface StudentDao {
	
	public void saveStudent (StudentInfo studentInfo);
    public List<StudentInfo> showAllStudents();
    public long countStudent ();
    
   
}
