package com.ethioclicks.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	
	@Column(name = "Id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "DepartmentName")
	private String departmentName;
	@Column(name = "RegDate")
	private Timestamp timeStamp;
	
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@OneToMany (fetch = FetchType.EAGER, mappedBy = "department")
	List<StudentInfo> listOfStudent;
	
	public List<StudentInfo> getListOfStudent() {
		return listOfStudent;
	}
	public void setListOfStudent(List<StudentInfo> listOfStudent) {
		this.listOfStudent = listOfStudent;
	}
}
