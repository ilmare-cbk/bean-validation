package org.example.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

class UserValidateTest {

    @Test
    @DisplayName("Bean Validation 작동 테스트 | 대상 : User")
    void validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        List<ConstraintViolation<User>> violations = new ArrayList<>(validator.validate(user));

        ConstraintViolation<User> violation = violations.get(0);
        Assertions.assertThat(violation.getMessage()).isEqualTo("Name cannot be null");
    }

    @Test
    @DisplayName("Bean Validation 다국어 테스트 (ko_KR) | 대상 : User V2")
    void validate2() {
        Locale.setDefault(Locale.KOREA);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        UserV2 user = new UserV2();

        Set<ConstraintViolation<UserV2>> violations = validator.validate(user);

        for (ConstraintViolation<UserV2> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.message = " + violation.getMessage());
        }
    }

    @Test
    @DisplayName("Bean Validation 다국어 테스트 (en_US) | 대상 : User V2")
    void validate3() {
        Locale.setDefault(Locale.US);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        UserV2 user = new UserV2();

        Set<ConstraintViolation<UserV2>> violations = validator.validate(user);

        for (ConstraintViolation<UserV2> violation : violations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.message = " + violation.getMessage());
        }
    }
}
