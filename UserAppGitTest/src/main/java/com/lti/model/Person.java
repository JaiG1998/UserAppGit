package com.lti.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb1_person")
public class Person {
	
	@Id
	@SequenceGenerator(name="seq_person",initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_person")
	@Column(name="person_id")
	private int personId;
	
	@Column(name="person_name")
	private String personName;
	
	@Column(name="person_age")
	private int personAge;

	public int getPersonId() {
		return personId;
	}
	
	@OneToOne(mappedBy="person",cascade=CascadeType.ALL) //it will not create any foreign key
	// mapped by: in the passport class there is a person object which is taking care of FK
	private Passport passport;
	
	@OneToOne(mappedBy="person", cascade=CascadeType.ALL)
	private Job job;
	
	@OneToOne(mappedBy="person", cascade=CascadeType.ALL)
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge + "]";
	}
	
	

}
