package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.model.Department;
import com.lti.model.Employee;

public class EmpDao {
	
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public void addEmployee(Employee emp){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		
		tx.begin();
		em.persist(emp);
		tx.commit();
		System.out.println("Employee added. ");
	}
	
	public void updateEmployee(Employee emp) {
		
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		
		tx.begin();
		em.merge(emp);      // do both the thing creation and updation
		tx.commit();
		System.out.println("Employee Updated. ");
		
		
		
	}
	
	public void deleteEmployee(Employee emp){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		
		tx.begin();
		em.remove(emp);
		tx.commit();
		System.out.println("Employee deleted. ");
	}
	
	public Employee findEmploye(int empId){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		
		Employee e = em.find(Employee.class, empId);
		
		return e;
	}
	
	public List<Employee> viewAllEmployees(){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		
		// JPQL(Java persistent Query Language)
		//String sql = "select emp from Employee emp";
		String sql = "select emp from Employee emp order by emp.empId";
		Query qry = em.createQuery(sql);
		
		List<Employee> employees = qry.getResultList();
		
		return employees;
		
	}
	
	
	public List<Employee> findUserByName(String name){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		
		String sql = "select emp from Employee emp where emp.empName=:en";
		Query qry = em.createQuery(sql);
		
		qry.setParameter("en", name);
		
		List<Employee> employees = qry.getResultList();
		return employees;
		
	}
	
	public void addNewDepartment(Department department){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		
		tx.begin();
		em.merge(department);
		tx.commit();
		System.out.println("Department added");
	}
	
	


}
