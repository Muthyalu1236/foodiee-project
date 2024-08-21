package com.foodiee.dto;

public class UserDto {
	
	int id;
	String name;
	String email;
	String Password;
	long phone;
	
	public UserDto() {
		
	}

	public UserDto(int id, String name, String email, String password, Long phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Password = password;
		this.phone = phone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", Password=" + Password + ", phone="
				+ phone + "]";
	}
	
}
