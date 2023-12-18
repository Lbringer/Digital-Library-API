package com.javabackend.digitalLibrary.createRequest;

import com.javabackend.digitalLibrary.models.Student;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentReq {
	@Positive
    private int age;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    public Student to(){
        return Student.builder()
                .name(name)
                .age(age)
                .email(email)
                .build();
    }
}
