package com.example.controller;

import com.example.movieuz.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "movie_category")
@Table
@Getter
@Setter
public class MovieCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = ("movie_id"))
    private UUID movieId;
    @ManyToOne
    @JoinColumn(name = ("movie_id"),insertable = false,updatable = false)
    private Movie movie;

    @Column(name = ("category_id"))
    private UUID categoryId;
    @ManyToOne
    @JoinColumn(name = ("category_id"),insertable = false,updatable = false)
    private Category category;
}