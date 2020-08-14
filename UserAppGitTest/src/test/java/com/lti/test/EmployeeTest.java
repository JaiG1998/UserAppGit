package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.EmpDao;
import com.lti.model.Employee;

public class EmployeeTest {

	@Test
	public void test() {
		//assertEquals("Jai", "Jai");
		EmpDao dao = new EmpDao();
		Employee emp = new Employee();
		
		emp.setEmpId(1);
		emp.setEmpName("Jai");
		emp.setEmpSalary(33500);
		
		assertEquals(emp, dao.findEmploye(1));
		assertTrue(emp.equals(dao.findEmploye(1)));
		
		
		
	}
	
	@Test
	public void addEmpTest() {
		//fail("Not yet implemented");
		EmpDao dao = new EmpDao();
		Employee emp = new Employee();
		
		emp.setEmpName("Merry");
		emp.setEmpSalary(5000);
		
		//assertNotNull(dao.addEmployee(emp);
		
	}
	
	@Test
	public void findEmpTest()
	{
		EmpDao dao = new EmpDao();
		Employee emp = dao.findEmploye(4);
		System.out.println(emp);
	}
}
