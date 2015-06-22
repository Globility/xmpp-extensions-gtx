package net.gltd.util.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;


/**
 * @author andyg
 */
public class IsAlphanumericNoWhitespaceValidator implements ConstraintValidator<IsAlphanumericNoWhitespace, String> {
	@Override
	public void initialize(IsAlphanumericNoWhitespace constraintAnnotation) {
		// nowt
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		return StringUtils.isAlphanumeric(value);
	}
}