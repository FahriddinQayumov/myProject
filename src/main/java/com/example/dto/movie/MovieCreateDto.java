package com.example.dto.movie;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class MovieCreateDto {

    @NotBlank(message = "Invalid title")
    private String title;
    @NotBlank(message = "Invalid description")
    private String description;
    private Double price;
    private LocalDate filmedOn;
}
