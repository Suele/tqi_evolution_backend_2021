package com.credit.analysis.validationDate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Suele Guimarães
 */
@Documented
@Constraint(validatedBy = ValidateDateFirstPortion.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
		ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFirstPortion {

	String message() default "A data da primeira parcela deve ser no máximo 3 meses após o dia atual.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
