package com.jbk.enums;

public enum InterviewStatus {

	SCHEDULED("SCHEDULED"),
	COMPLETED("COMPLETED"),
	CANCELLED("CANCELLED");
	
	private final String value;
	
	InterviewStatus(String value) {

		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
