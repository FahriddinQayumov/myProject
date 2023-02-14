package com.example.dto.category;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryCreateDto {
    @NotBlank(message = "Invalid category name")
    private String name;
    @NotBlank(message = "Invalid category description")
    private String description;
}
