package com.example.controller;

import com.example.movieuz.Movie;
import com.example.movieuz.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="orders")
@Getter
@Setter
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name=("user_id"),insertable = false,updatable = false)
    private User user;
    @Column(name =("user_id"))
    private UUID userID;

    @ManyToOne
    @JoinColumn(name=("movie_id"),insertable = false,updatable = false)
    private Movie movie;
    @Column(name = ("movie_id"))
    private UUID movieID;
}
