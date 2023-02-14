package com.example.dto.movie;

import com.example.movieuz.MovieStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class MovieDetailDto {
    private UUID id;
    private String title;
    private String description;
    private Double price;
    private MovieStatus status;
    private LocalDate filmedOn;
}
