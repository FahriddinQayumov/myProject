package com.example.dto.user;

import com.example.enums.City;
import com.example.enums.Gender;
import com.example.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserDetailDto {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
    private Gender gender;
    private String address;
    private City city;
    private UserStatus userStatus;
    private Double wallet;
}
