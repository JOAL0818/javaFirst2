package io;

import java.io.Serializable;

public class Member implements Serializable{
	private String email;
	private String pw;
	private String phone;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return "MemberClass [email=" + email + ", pw=" + pw + ", phone=" + phone + "]";
	}	
}
