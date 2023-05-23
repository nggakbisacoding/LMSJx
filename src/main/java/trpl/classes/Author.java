/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trpl.classes;

import java.io.Serializable;

public class Author extends Person implements Serializable{

	private int Id;
	private String credentials;
	private String shortBio;
	
	

	public Author(int id,String firstName, String lastName, Address address, String phoneNumber,  String credentials,
			String shortBio) {
		super(firstName, lastName, address, phoneNumber);
		Id = id;
		this.credentials = credentials;
		this.shortBio = shortBio;
	}

	public String getCredentials() {
		return credentials;
	}

	public String getShortBio() {
		return shortBio;
	}
	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}

    /**
     *
     * @return
     */
    @Override
	public String toString() {
		return getFirstName() +" "+getLastName();
	}
}

