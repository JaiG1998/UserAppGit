package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.Address;
import com.lti.model.Job;
import com.lti.model.Passport;
import com.lti.model.Person;

public class PersonDao {
	
	EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx; 
    
	public void addPerson(Person person){
		
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.merge(person);
		tx.commit();
		
	}
	
public void addPassport(Passport passport){
		
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.merge(passport);
		tx.commit();
		
	}

public Person findPerson(int id){
	
	emf = Persistence.createEntityManagerFactory("pu");
	em = emf.createEntityManager();
	return em.find(Person.class, id);
	
}

public void addPersonWithJob(Person person, Job job){                             // new job new person
	
	emf = Persistence.createEntityManagerFactory("pu");
	em = emf.createEntityManager();
	tx = em.getTransaction();
	
	person.setJob(job);
	job.setPerson(person);
	
	tx.begin();
	em.merge(person);
	tx.commit();
	
}

public void addJobWithPerson(Job job, int personId){                                  // new job with exiting person
	emf = Persistence.createEntityManagerFactory("pu");
	em = emf.createEntityManager();
	
	Person person = findPerson(personId);
	tx = em.getTransaction();
	job.setPerson(person);
	
	tx.begin();
	em.merge(job);
	tx.commit();
	
	
}

public void addPersonWithAddress(Person person, Address address){                             
	
	emf = Persistence.createEntityManagerFactory("pu");
	em = emf.createEntityManager();
	tx = em.getTransaction();
	
	person.setAddress(address);
	address.setPerson(person);
	
	tx.begin();
	em.merge(person);
	tx.commit();
	
}

public void addAddressWithPerson(Address address, int personId){  
	emf = Persistence.createEntityManagerFactory("pu");
	em = emf.createEntityManager();
	
	Person person = findPerson(personId);
	tx = em.getTransaction();
	address.setPerson(person);
	
	tx.begin();
	em.merge(address);
	tx.commit();
	
	
}



}
