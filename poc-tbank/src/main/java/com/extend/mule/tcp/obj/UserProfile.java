package com.extend.mule.tcp.obj;

import java.io.Serializable;

public class UserProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5993551129354405564L;

	private String userName;
	private String lastName;
	private String timeZone;
	private String zipCode;
	
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
