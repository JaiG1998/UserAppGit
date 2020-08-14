package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb1_department")
public class Department {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	private int departmentId;
	private String departmentName;
	private String location;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", location="
				+ location + "]";
	}
	
	

}
