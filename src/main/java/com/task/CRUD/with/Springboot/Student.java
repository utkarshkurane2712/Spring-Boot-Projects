package com.task.CRUD.with.Springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Student {
	
	@Id
	int id;
	String name;
	String number;
	String address;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", number=" + number + ", address=" + address + "]";
	}
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student(int id, String name, String number, String address) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.address = address;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
