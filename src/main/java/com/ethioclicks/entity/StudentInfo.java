package com.ethioclicks.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentinfo")
public class StudentInfo {
    @Column(name = "Id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(name = "FirstName")
	private String firstName;
    @Column(name = "LastName")
	private String lastName;
    @Column(name = "Gender")
	private String gender;
    @Column(name = "Department")
	private String department;
    @Column(name = "Batch")
	private String batch;
    @Column(name = "Description")
	private String description;
    @Column(name = "RegDate")
    private Timestamp timeStamp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		department = department;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		batch = batch;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		description = description;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
