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
@Table(name="tb1_job")
public class Job {
	
	@Id
	@SequenceGenerator(name="seq_job",initialValue=10)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_job")
	private int jobId;
	
	@Column
	private String jobRole;
	
	@Column
	private String jobLocation;
	
	@OneToOne
	@JoinColumn(name="person_id")
	private Person person;
	
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobRole=" + jobRole + ", jobLocation=" + jobLocation + "]";
	}
	
	

}
