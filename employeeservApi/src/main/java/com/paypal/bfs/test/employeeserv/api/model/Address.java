package com.paypal.bfs.test.employeeserv.api.model;

import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private double id;
	@JsonProperty("line1")
	private String line1;
	@JsonProperty("line2")
	private String line2;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("country")
	private String country;
	@JsonProperty("zipcode")
	private String zipcode;

	public Address(Address address) {
		Random rd = new Random();
		this.id = rd.nextInt(100);
		this.line1 = address.getLine1();
		this.line2 = address.line2;
		this.city = address.city;
		this.state = address.state;
		this.country = address.getCountry();
		this.zipcode = address.getZipcode();
	}

	public Address() {

	}

	@JsonProperty("line1")
	public String getLine1() {
		return line1;
	}

	@JsonProperty("line2")
	public String getLine2() {
		return line2;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("zipcode")
	public String getZipcode() {
		return zipcode;
	}

	@JsonProperty("id")
	public void setId(double id) {
		this.id = id;
	}

	@JsonProperty("id")
	@Id public double getId() {
		return id;
	}

	@JsonProperty("line1")
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	@JsonProperty("line2")
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("zipcode")
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override public String toString() {
		return "Address{" + "id=" + id + ", line1='" + line1 + '\'' + ", line2='" + line2 + '\'' + ", city='" + city
				+ '\'' + ", state='" + state + '\'' + ", country='" + country + '\'' + ", zipcode='" + zipcode + '\''
				+ '}';
	}
}
