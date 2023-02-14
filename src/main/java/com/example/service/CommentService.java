package com.example.service;

import com.example.controller.Comment;
import com.example.dto.comment.CommentCreateDto;
import com.example.dto.comment.CommentDetailDto;
import com.example.dto.comment.CommentUpdateDto;
import com.example.exceptions.BadRequest;
import com.example.repositoryy.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public void create(CommentCreateDto dto) {
        Comment entity=new Comment();
        convertDtoToEntity(dto,entity);
        commentRepository.save(entity);
    }

    private void convertDtoToEntity(CommentCreateDto dto, Comment entity) {
        entity.setMovieID(dto.getMovieID());
        entity.setUserID(dto.getUserID());
    }

    public CommentDetailDto get(UUID id) {
        CommentDetailDto dto=new CommentDetailDto();
        convertEntityToDto(getEntity(id),dto);
        return dto;
    }

    private void convertEntityToDto(Comment entity, CommentDetailDto dto) {
        dto.setUserID(entity.getUserID());
        dto.setMovieID(entity.getMovieID());
    }

    private Comment getEntity (UUID id){
        Optional<Comment> optional=commentRepository.findById(id);
        if(optional.isEmpty()){
            throw new BadRequest("Comment topilmadi");
        }
        return optional.get();
    }

    public void update(UUID id, CommentUpdateDto dto) {
        Comment entity=getEntity(id);
        if(dto.getMovieID()!=null){
            entity.setMovieID(dto.getMovieID());
        }if(dto.getUserID()!=null){
            entity.setUserID(dto.getUserID());
        }
    }

    public void delete(UUID id) {
        commentRepository.delete(getEntity(id));
    }
}
