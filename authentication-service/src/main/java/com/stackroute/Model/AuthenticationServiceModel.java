package com.stackroute.Model;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AuthenticationServiceModel {

	private int userId;
	private String userName;
	private String password;
	private String userRole;
	private String email;

	 
	@Override
	public String toString() {
		return "AuthenticationServiceModel [userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", userRole=" + userRole + ", email=" + email + "]";
	}
	public AuthenticationServiceModel() {
		super();
	}
	public AuthenticationServiceModel(int userId, String userName, String password, String userRole, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	
	/*
	 * @Override public String toString() { return
	 * "AuthenticationServiceModel [userId=" + userId + ", userName=" + userName +
	 * ", password=" + password + ", userRole=" + userRole + ", email=" + email +
	 * "]"; } public AuthenticationServiceModel(int userId, String userName, String
	 * password, String userRole, String email) { super(); this.userId = userId;
	 * this.userName = userName; this.password = password; this.userRole = userRole;
	 * this.email = email; } public AuthenticationServiceModel() { super(); }
	 */
}
