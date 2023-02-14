package com.example.service;


import com.example.dto.movie.MovieCreateDto;
import com.example.dto.movie.MovieDetailDto;
import com.example.dto.movie.MovieUpdateDto;
import com.example.exceptions.BadRequest;
import com.example.repositoryy.MovieRepository;
import com.example.movieuz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void create(MovieCreateDto dto) {
        Movie entity =new Movie();
        if(dto.getPrice()<0){
            throw new BadRequest("Invalid price");
        }
        convertDtoToEntity(dto,entity);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setStatus(MovieStatus.Created);

        movieRepository.save(entity);
    }


    public MovieDetailDto get(UUID id) {
        Movie entity=getEntity(id);
        MovieDetailDto dto=new MovieDetailDto();
        MovieDetailDto result=convertEntityToDto(entity,dto);
        return result;
    }

    public Movie getEntity(UUID id){
        Optional<Movie> entity=movieRepository.findById(id);
        if(entity.isEmpty()){
            throw new BadRequest("Movie not fount");
        }
        return entity.get();
    }

    public void update(UUID id, MovieUpdateDto dto) {
        Movie entity=getEntity(id);
        if(dto.getTitle()!=null){
            checkString(dto.getTitle(),"title");
            entity.setTitle(dto.getTitle());
        }if(dto.getDescription()!=null){
            checkString(dto.getDescription(),"description");
            entity.setDescription(dto.getDescription());
        }if(dto.getPrice()!=null){
            entity.setPrice(dto.getPrice());
        }if(dto.getFilmedOn()!=null&&dto.getFilmedOn().getYear()<1888){
            entity.setFilmedOn(dto.getFilmedOn());
        }
        entity.setUpdatedAt(LocalDateTime.now());
        movieRepository.save(entity);
    }

    public void delate(UUID id) {
        movieRepository.delete(getEntity(id));
    }

    private MovieDetailDto convertEntityToDto(Movie entity, MovieDetailDto dto) {
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setStatus(entity.getStatus());
        dto.setFilmedOn(entity.getFilmedOn());
        return dto;
    }

    private void convertDtoToEntity(MovieCreateDto dto, Movie entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setFilmedOn(dto.getFilmedOn());
    }

    public List<MovieDetailDto> getAll(Integer page, Integer lim) {
        if(page==null||page<0){
            page=0;
        }if(lim==null||lim<1){
            lim=10;
        }
        PageRequest request=PageRequest.of(page,lim);
        Page<Movie> moviesPage=movieRepository.findAll(request);
        List<MovieDetailDto> dtoList=new ArrayList<>();
        for (Movie movie :moviesPage) {
            dtoList.add(convertEntityToDto(movie,new MovieDetailDto()));
        }
        return dtoList;
    }
    private void checkString(String data , String nameOfdata){
        if (data.charAt(0)==' '||data.charAt(data.length()-1)==' '){
            throw new BadRequest(String.format("Invalid %s" ,nameOfdata));
        }
    }

    public void changeStatus(UUID id, MovieStatus status) {
        Movie entity=getEntity(id);
        entity.setStatus(status);
        movieRepository.save(entity);
    }
}



