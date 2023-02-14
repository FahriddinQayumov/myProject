package com.example.dto.comment;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CommentDetailDto {
    private UUID movieID;
    private UUID userID;
    private LocalDateTime createdAt;
}
