package com.example.dto.movie;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class MovieUpdateDto {
    private String title;
    private String description;
    @Size(min = 0,message = "Price should be positive")
    private Double price;
    private LocalDate filmedOn;
}
