package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.PersonDao;
import com.lti.model.Address;
import com.lti.model.Job;
import com.lti.model.Passport;
import com.lti.model.Person;

public class PersonPassportTest {

	PersonDao dao = new PersonDao();
	@Test
	public void addPersonTest() {
		Person person = new Person();
		person.setPersonName("Jim");
		person.setPersonAge(30);
			
		
		//person.setPassport(passport);
		dao.addPerson(person);
		
		//passport.setPerson(person);
		
	}
	@Test
	public void addPassportTest(){
		
		Passport passport = new Passport();
		passport.setCountry("India");
		passport.setValidFrom(LocalDate.now());
		passport.setValidTo(LocalDate.now().plusYears(2));
		
		dao.addPassport(passport);
	}
	
	
	@Test
	public void addPassportWithPersonTest(){
		Person person = new Person();
		person.setPersonName("Martin");
		person.setPersonAge(25);
		
		Passport passport = new Passport();
		passport.setCountry("Japan");
		passport.setValidFrom(LocalDate.now());
		passport.setValidTo(LocalDate.now().plusYears(2));
		
		passport.setPerson(person);
		person.setPassport(passport);
		
		dao.addPerson(person);
	}
	
	/*@Test
	public void findPersonAndPassportNo(){
		Person p  =dao.findPerson(102);
		System.out.println(p);
		System.out.println(p.getPassport().getPassportNo());
	}*/
	
	
	@Test
	public void addPersonWithJob(){
		
		Person person = new Person();
		person.setPersonName("Ross");
		person.setPersonAge(45);
		
		Job job = new Job();
		job.setJobRole("Admin");
		job.setJobLocation("Pune");
		
		dao.addPersonWithJob(person, job);
	}
	
	@Test
	public void addJobWithPerson(){
		Job job = new Job();
		job.setJobLocation("Mumbai");
		job.setJobRole("HR");
		
		dao.addJobWithPerson(job, 1);
	
	}
	
	
	@Test
	public void addPersonWithAddress(){
		
		Person person = new Person();
		person.setPersonName("Jolly");
		person.setPersonAge(24);
		
		Address address = new Address();
		address.setHouseNo("23/12");
		address.setLandMark("Opposite XYZ Building");
		address.setPinCode("324007");
		
		
		dao.addPersonWithAddress(person, address);
	}
	
	@Test
	public void addAddressWithPerson(){
		Address address = new Address();
		address.setHouseNo("26/24");
		address.setLandMark("Opposite Manohar Building");
		address.setPinCode("324002");
		
		dao.addAddressWithPerson(address, 602);
	
	}
	
	
	
	
	

}
