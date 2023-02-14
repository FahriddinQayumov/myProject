package com.example.controller;

import com.example.dto.order.OrderCreateDto;
import com.example.movieuz.Movie;
import com.example.movieuz.User;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderContrioller {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderCreateDto dto){
        orderService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id){
        Order result=orderService.get(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Order> orders=orderService.getAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getAllByUserId(@PathVariable UUID id){
        List<Movie> userOrders=orderService.getAllByUserId(id);
        return ResponseEntity.ok(userOrders);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getAllByMovieId(@PathVariable UUID id){
        List<User> userList=orderService.getAllByMovieId(id);
        return ResponseEntity.ok(userList);
    }

}
