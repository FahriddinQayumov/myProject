package com.example.movieuz;

import com.example.enums.City;
import com.example.enums.Gender;
import com.example.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name ="users")
@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @Column(name = ("birth_date"))
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    @Enumerated(EnumType.STRING)
    private City city;
    @Column (name= ("created_at"))
    private LocalDateTime createdAt;
    @Column (name= ("updated_at"))
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @Column (name= ("wallet"))
    private Double wallet;

    public User (){
        this.wallet=0.0;
    }



}
