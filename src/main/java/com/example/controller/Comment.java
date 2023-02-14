package com.example.controller;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = ("comment"))
@Table
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String content;
    private UUID userID;
    private UUID movieID;

}
