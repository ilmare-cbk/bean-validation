package org.example.domain;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserV2 {
    @NotNull(message = "{user.name.invalid}")
    private String name;

    @AssertTrue
    private boolean working;

    @Size(min = 10, max = 200)
    private String aboutMe;

    @Min(value = 18)
    @Max(value = 150)
    private int age;

    @Email
    private String email;
}
