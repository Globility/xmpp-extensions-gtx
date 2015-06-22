package net.gltd.util.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author andyg
 */
public class NotBlankStringValidator implements ConstraintValidator<NotBlank, String> {
	@Override
	public void initialize(NotBlank constraintAnnotation) {
		// nowt
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		return value.length() > 0;
	}
}