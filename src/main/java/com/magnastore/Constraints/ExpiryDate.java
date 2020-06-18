package com.magnastore.Constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@NotNull
@Size(min = 1)
@ReportAsSingleViolation
@Pattern(regexp = "?:0[1-9]|1[0-2])/[0-9]{2}")
@Constraint(validatedBy = { })
public @interface ExpiryDate {
	
	String message() default "{com.magnastore.constraints.InvalidExpiryDate.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
