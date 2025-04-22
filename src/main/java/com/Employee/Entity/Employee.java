package com.Employee.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Employee")
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public int id;
	public String name;
	public String gender;
	public int salary;
	public float experience;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getSalary() {
		return salary;
	}
	public float getExperience() {
		return experience;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setExperience(float experience) {
		this.experience = experience;
	}
	
}
