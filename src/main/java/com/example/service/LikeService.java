package com.example.service;

import com.example.movieuz.Like;
import com.example.repositoryy.LikeRepository;
import com.example.exceptions.BadRequest;
import com.example.movieuz.Movie;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    MovieService movieService;

    public void create(Like like) {
        like.setCreatedAt(LocalDateTime.now());
        changeMovieRate(like.getMovieId());
        likeRepository.save(like);
    }


    private void changeMovieRate( UUID id){
        Long number=likeRepository.countAllByMovieId(id);
        Long likeNumber= likeRepository.countAllByMovieIdAndIsLikeTrue(id);
        Movie movie= movieService.getEntity(id);
        Long result=(likeNumber/number)*100;
        movie.setRate(result.shortValue());
    }

    public Like get(UUID id) {
        Optional<Like> entity=likeRepository.findById(id);
        if(entity.isEmpty()){
            throw new BadRequest("Like qo'yilmagan");
        }
        return entity.get();
    }



    public void delete(UUID id) {
        likeRepository.delete(get(id));
    }



    public List<Like> getAll() {
        return likeRepository.findAll();
    }

    public List<Movie> getAllByUserId(UUID id) {
        List<Movie> movieList=new LinkedList<>();
        List<Like>likeList=likeRepository.getAllByUserId(id);
        for (Like like :likeList) {
            movieList.add(like.getMovie());
        }
        return movieList;
    }

    public List<User> getAllByMovieId(UUID id) {
        List<User> userList=new LinkedList<>();
        List<Like>likeList=likeRepository.getAllByMovieId(id);
        for (Like like :likeList) {
            userList.add((User) like.getUser());
        }
        return userList;
    }
}