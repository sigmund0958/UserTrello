package com.majorbit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Richieste_Fazi {

	@Id
	private Integer id;
	@Column
	private String status;
	@ManyToOne
	private User_Trello_Fazi sendingUser;
	@ManyToOne
	private User_Trello_Fazi receivingUser;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User_Trello_Fazi getSendingUser() {
		return sendingUser;
	}
	public void setSendingUser(User_Trello_Fazi sendingUser) {
		this.sendingUser = sendingUser;
	}
	public User_Trello_Fazi getReceivingUser() {
		return receivingUser;
	}
	public void setReceivingUser(User_Trello_Fazi receivingUser) {
		this.receivingUser = receivingUser;
	}
	@Override
	public String toString() {
		return "Richieste_Fazi [id=" + id + ", status=" + status + ", sendingUser=" + sendingUser + ", receivingUser="
				+ receivingUser + "]";
	}
	public Richieste_Fazi(Integer id, String status, User_Trello_Fazi sendingUser, User_Trello_Fazi receivingUser) {
		super();
		this.id = id;
		this.status = status;
		this.sendingUser = sendingUser;
		this.receivingUser = receivingUser;
	}
	public Richieste_Fazi() {};
}
