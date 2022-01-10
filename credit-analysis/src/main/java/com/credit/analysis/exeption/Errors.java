package com.credit.analysis.exeption;

import java.util.Optional;

public class Errors {
	private String errorMessage;

	public Errors(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
