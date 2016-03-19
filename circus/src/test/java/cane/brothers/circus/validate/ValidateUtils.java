package cane.brothers.circus.validate;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateUtils {

	private static final Logger log = LoggerFactory.getLogger(ValidateUtils.class);

	
	public static <T> Set<ConstraintViolation<T>> validate(T object, Validator validator) {
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);

		log.error(object.toString());
		log.error(String.format("Кол-во ошибок: %d", constraintViolations.size()));

		for (ConstraintViolation<T> cv : constraintViolations)
			log.error(String.format("Ошибка! property: [%s], value: [%s], message: [%s]",
					cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
		
		return constraintViolations;
	}
}
