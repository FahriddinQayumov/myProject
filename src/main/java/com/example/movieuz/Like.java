package com.example.movieuz;

import com.example.movieuz.Movie;
import com.example.movieuz.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

    @Entity(name = "likes")
    @Table
    @Getter
    @Setter
    public class Like {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        @Column(name = ("user_id"))
        private UUID userId;
        @Column(name = ("is_like"))
        private Boolean isLike;
        @ManyToOne
        @JoinColumn(name = ("user_id") ,insertable = false,updatable = false)
        private User user;

        @Column(name = ("movie_id"))
        private UUID movieId;
        @ManyToOne
        @JoinColumn(name=("movie_id"),insertable = false,updatable = false)
        private Movie movie;
        @Column(name = ("created_at"))
        private LocalDateTime createdAt;

    }

