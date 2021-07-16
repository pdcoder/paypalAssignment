package com.paypal.bfs.test.employeeserv.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Employee resource
 * <p>
 * Employee resource object
 *
 */
@Entity
@Table(name = "employee")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"id",
		"first_name",
		"last_name",
		"dob",
		"address"
})
public class Employeee {

	/**
	 * employee id
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	@JsonPropertyDescription("employee id")
	private Integer id;
	/**
	 * first name
	 * (Required)
	 *
	 */
	@JsonProperty("first_name")
	@JsonPropertyDescription("first name")
	private String firstName;
	/**
	 * last name
	 * (Required)
	 *
	 */
	@JsonProperty("last_name")
	@JsonPropertyDescription("last name")
	private String lastName;

	@JsonProperty("dob")
	@JsonPropertyDescription("Date of birth")
	private String dob;

	@JsonProperty("address")
	@OneToOne(targetEntity = Address.class, cascade = { CascadeType.ALL})
	private Address address;


	/**
	 * employee id
	 *
	 */
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	/**
	 * employee id
	 *
	 */
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * first name
	 * (Required)
	 *
	 */
	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * first name
	 * (Required)
	 *
	 */
	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * last name
	 * (Required)
	 *
	 */
	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * last name
	 * (Required)
	 *
	 */
	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("dob")
	public String getDob() {
		return dob;
	}

	@JsonProperty("dob")
	public void setDob(String dob) {
		this.dob = dob;
	}

	@JsonProperty("address")
	public Address getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Employeee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null)?"<null>":this.id));
		sb.append(',');
		sb.append("firstName");
		sb.append('=');
		sb.append(((this.firstName == null)?"<null>":this.firstName));
		sb.append(',');
		sb.append("lastName");
		sb.append('=');
		sb.append(((this.lastName == null)?"<null>":this.lastName));
		sb.append(',');
		sb.append("Date of birth");
		sb.append('=');
		sb.append(((this.dob == null)?"<null>":this.dob));
		sb.append(',');
		if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
