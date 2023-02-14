package com.example.service;

import com.example.controller.Order;
import com.example.dto.order.OrderCreateDto;
import com.example.repositoryy.OrderRepository;
import com.example.exceptions.BadRequest;
import com.example.movieuz.Movie;
import com.example.movieuz.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MovieService movieService;

    @Autowired
    UserService userService;


    public void create(OrderCreateDto dto) {
        Order entity=new Order();
        entity.setUserID(dto.getUserId());
        entity.setMovieID(dto.getMovieId());
        entity.setCreatedAt(LocalDateTime.now());
        User user=userService.getEntity(dto.getUserId());
        Movie movie=movieService.getEntity(dto.getMovieId());
        if(user.getWallet()<movie.getPrice()){
            throw new BadRequest("Userning puli yetarli emas");
        }else{
            user.setWallet(user.getWallet()-movie.getPrice());
        }
        orderRepository.save(entity);
    }

    public Order get(UUID id) {
        Optional<Order> optional=orderRepository.findById(id);
        if(optional.isEmpty()){
            throw new BadRequest("Buyurtma berilmadi");
        }
        return optional.get();
    }

    public void delete(UUID id) {
        orderRepository.delete(get(id));
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public List<Movie> getAllByUserId(UUID id) {
        List<Movie> movieList=new LinkedList<>();
        List<Order> orderList=orderRepository.getAllByUserId(id);
        for (Order order :orderList) {
            movieList.add(order.getMovie());
        }
        return movieList;
    }

    public List<User> getAllByMovieId(UUID id) {
        List<User> userList=new LinkedList<>();
        List<Order> orderList=orderRepository.getAllByMovieId(id);
        for (Order order :orderList) {
            userList.add(order.getUser());
        }
        return userList;
    }
}
