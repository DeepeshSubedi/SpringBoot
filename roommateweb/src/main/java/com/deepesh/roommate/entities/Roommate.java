package com.deepesh.roommate.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roommate {
	@Id
	private int id;
	private String name;
	private String gender;
	private String phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Roommate [id=" + id + ", name=" + name + ", gender=" + gender + ", phone=" + phone + "]";
	}
	
	

}

