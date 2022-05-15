package com.tutorial.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class inq {
	private String type;
	private String reason;
	private int id;
	private int userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "inq [type=" + type + ", reason=" + reason + ", id=" + id + ", userId=" + userId+ "]";
	}
	
	
	
}
