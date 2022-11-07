package com.api.quasar.modelErro;

import java.util.Date;

public class ModelErro {

	private Integer status;
	private Date timestap;
	private String message;
	private String path;

	public ModelErro() {
		// TODO Auto-generated constructor stub
	}

	public ModelErro(Integer status, Date timestap, String message, String path) {
		super();
		this.status = status;
		this.timestap = timestap;
		this.message = message;
		this.path = path;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getTimestap() {
		return timestap;
	}

	public void setTimestap(Date timestap) {
		this.timestap = timestap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}