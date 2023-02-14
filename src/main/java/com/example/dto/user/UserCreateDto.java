package com.example.dto.user;


import   com.example.enums.City;
import com.example.enums.Gender;
import org.jetbrains.annotations.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class UserCreateDto {
    @NotBlank(message = "Invalid name")
    private String name;
    @NotBlank(message = "Invalid surname")
    private String surname;
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Invalid password")
    @Length(min=8,max = 30, message = ("password"))
    private String password;
    private LocalDate birthDate;
    private Gender gender;
    @NotBlank(message = "Invalid address")
    private String address;
    private City city;
}
