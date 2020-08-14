package com.lti.main;

import java.util.List;

import com.lti.dao.EmpDao;
import com.lti.model.Department;
import com.lti.model.Employee;

public class App {

	public static void main(String[] args) {
		
		EmpDao dao = new EmpDao();
		
		/*Employee emp = new Employee();
		emp.setEmpName("Jai");
		emp.setEmpSalary(35000);
				
		dao.addEmployee(emp);*/
		
		/*Employee emp = new Employee();
		emp.setEmpId(2);
		emp.setEmpName("Jack");
		emp.setEmpSalary(34000);
		dao.updateEmployee(emp);*/
		
		//System.out.println(dao.findEmploye(1));

		/*List<Employee> employees = dao.viewAllEmployees();
		
		System.out.println(employees);*/
		
		
		//List<Employee> employees =  dao.findUserByName("Jai");
		//System.out.println(employees);
		
		Department department = new Department();
		department.setDepartmentName("Finance");
		department.setLocation("Mahape");
		
		dao.addNewDepartment(department);
	}

}



/*
<property name="hibernate.dialect" value="org.hibernate.dialect.Oracle12cDialect" />
*/