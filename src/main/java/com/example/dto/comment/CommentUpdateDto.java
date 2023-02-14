package com.example.dto.comment;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CommentUpdateDto {

    private UUID movieID;
    private UUID userID;
}
