package com.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	protected Employee() {
	}

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Employee[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
	
	

	public String getSurname() {
		return String.format("Employee[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

	
	public String getFirstname() {
		return String.format("Employee[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
	
	
	public Object getName() {
		return this.firstName;
	}

	public Long getId() {
		return this.id;
	}
}
