package com.lti.model;

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
@Table(name="tb1_address")
public class Address {
	
	@Id
	@SequenceGenerator(name="seq_address",initialValue=10000)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_address")
	private int addressId;
	
	@Column
	private String houseNo;
	
	@Column
	private String landMark;
	
	@Column
	private String pinCode;
	
	@OneToOne
	@JoinColumn(name="person_id")
	private Person person;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNo=" + houseNo + ", landMark=" + landMark + ", pinCode="
				+ pinCode + ", person=" + person + "]";
	}
	
	

}
