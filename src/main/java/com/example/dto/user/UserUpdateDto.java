package com.example.dto.user;

import com.example.enums.City;
import com.example.enums.Gender;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class UserUpdateDto {
    private String name;
    private String surname;
    @Email(message = "Invalid email format")
    private String email;
    @Length(min=8,max = 30,message = "Password should be min 8 and max 30")
    private String password;
    private LocalDate birthDate;
    private Gender gender;
    private String address;
    private City city;
}
