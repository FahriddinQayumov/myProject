package com.example.dto.comment;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class CommentCreateDto {

    @NotBlank(message = "Invalid category user_id")
    private UUID userID;
    @NotBlank(message = "Invalid category movie_id")
    private UUID movieID;

}
