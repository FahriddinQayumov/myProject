package com.example.dto.order;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderCreateDto {
    private UUID userId;
    private UUID movieId;
}
