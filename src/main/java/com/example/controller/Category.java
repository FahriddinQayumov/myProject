package com.example.controller;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity(name = ("categories"))
@Table
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updatedAT;
}
