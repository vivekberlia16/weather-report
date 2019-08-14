package com.report.demo.exceptions;

public class WeatherAppException extends Exception {
	
	private static final long serialVersionUID = -8999932578270387947L;

	private Integer status;

	private String message;


	public WeatherAppException(int status, String message) {
		super(message);
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
