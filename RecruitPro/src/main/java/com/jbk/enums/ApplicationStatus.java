package com.jbk.enums;

public enum ApplicationStatus {

	APPLIED("SUBMITTED"),
	APPROVED("APPROVED"),
	REJECTED("REJECTED");
	
	private final String value;
	
	ApplicationStatus(String value) {

		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
