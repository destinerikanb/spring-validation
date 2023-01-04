package com.destinerikanb.springvalidation;

import com.destinerikanb.springvalidation.data.Person;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class ValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    void testPersonNotValid() {
        var person = new Person("", "");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(2, violations.size());
    }

    @Test
    void testPersonValid() {
        var person = new Person("Destin", "Erika");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertTrue(violations.isEmpty());
    }
}
