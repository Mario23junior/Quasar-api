package com.api.quasar.modelErro;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ModelErro {

	private Integer status;
	private String message;
	private String path;

	public ModelErro() {
 	}

	public ModelErro(Integer status, Date timestap, String message, String path) {
		super();
		this.status = status;
		this.message = message;
		this.path = path;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTimestap() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		return formatter.format(calendar.getTime());
	}	

	public void setTimestap(Date timestap) {
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