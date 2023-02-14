package com.example.dto.category;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CategoryDetailDto {
    private String name;
    private String description;
    private LocalDateTime createdAt;
}
