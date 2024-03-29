package com.thanhhc.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private int id;
	private String email;
	private String username;
	private String password;
	private String avatar;
	private int roleId;
	private int age;
	private Date dateOfBirth;
	private String address;
	public User() {
		super();
	}
	public User(String email, String username, String password, Date dateOfBirth, String address) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}
	public User(int id, String email, String username, String password, String avatar, int roleId, int age, Date dateOfBirth, String address) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
		this.roleId = roleId;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
