package com.majorbit.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_Trello_Fazi {

	@Id
	private String email;
	@Column
	private String password; 
	@Column
	private Date registrationDate;
	@Column
	private String gender;
	@Column
	private String profilePic;
	@Column
	private Integer score;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "User_Trello_Fazi [email=" + email + ", password=" + password + ", registrationDate=" + registrationDate
				+ ", gender=" + gender + ", profilePic=" + profilePic + ", score=" + score + "]";
	}
	public User_Trello_Fazi(String email, String password, Date registrationDate, String gender, String profilePic,
			Integer score) {
		super();
		this.email = email;
		this.password = password;
		this.registrationDate = registrationDate;
		this.gender = gender;
		this.profilePic = profilePic;
		this.score = score;
	}
	public User_Trello_Fazi() {};
}
