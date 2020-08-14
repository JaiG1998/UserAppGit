package com.lti.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb1_passport")
public class Passport {
	
	@Id
	@SequenceGenerator(name="seq_pass",initialValue=1000)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_pass")
	private int passportNo;
	
	@Column
	private String country;
	
	@Column
	private LocalDate validFrom;
	
	@Column
	private LocalDate validTo;
	
	@OneToOne
	@JoinColumn(name="person_id")
	private Person person;

	public int getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}

	public LocalDate getValidTo() {
		return validTo;
	}

	public void setValidTo(LocalDate validTo) {
		this.validTo = validTo;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", country=" + country + ", validFrom=" + validFrom + ", validTo="
				+ validTo + ", person=" + person + "]";
	}
	
	

}
