/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trpl.classes;

import java.io.Serializable;

/**
 *
 * @author Fandead
 */
public class Address implements Serializable{

	private String street;
	private String city;
	private String state;
	private Integer zip;
	
	public Address(String street, String city, String state, Integer zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public Integer getZip() {
		return zip;
	}
	
        @Override
	public String toString() {
		return getStreet() +", "+ getCity() +", "+getState() +", "+getZip();
	}
}

