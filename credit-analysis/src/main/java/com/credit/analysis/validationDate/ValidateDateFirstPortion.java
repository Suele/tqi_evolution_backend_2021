package com.credit.analysis.validationDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ValidateDateFirstPortion implements ConstraintValidator<DateFirstPortion, LocalDate> {

	@Override
	public void initialize(DateFirstPortion constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
		LocalDate DateOfTomorrow = LocalDate.now().plusDays(1);
		LocalDate DateMaximaFirstInstallment = DateOfTomorrow.plusMonths(3);

		return localDate == null ? false : localDate.isBefore(DateMaximaFirstInstallment) || localDate.isEqual(DateMaximaFirstInstallment);
	}
}
