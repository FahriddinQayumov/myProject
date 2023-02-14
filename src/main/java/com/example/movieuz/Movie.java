package com.example.movieuz;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@Entity(name = "movies")
@Table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private Double price;
    @Column(name = ("filmed_on"))
    private LocalDate filmedOn;
    private Short rate;
    private Long views;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private MovieStatus status;
}
