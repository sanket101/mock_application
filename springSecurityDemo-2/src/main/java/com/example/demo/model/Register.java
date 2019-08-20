package com.example.demo.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Register {
	
	@Id
	private int userid;
	private String emailid;
	private boolean emailconfirmationflag;
	private Date accountcreationtime;
	
	public Register() {
		super();
	}
	
	public Register(int id, String mail) {
		this.userid = id;
		this.emailid = mail;
		this.emailconfirmationflag = false;
		this.accountcreationtime = null;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public boolean isEmailconfirmationflag() {
		return emailconfirmationflag;
	}

	public void setEmailconfirmationflag(boolean emailconfirmationflag) {
		this.emailconfirmationflag = emailconfirmationflag;
	}

	public Date getAccountcreationtime() {
		return accountcreationtime;
	}

	public void setAccountcreationtime(Date accountcreationtime) {
		this.accountcreationtime = accountcreationtime;
	}
		
	
}
