package com.example.controller;

import com.example.dto.user.UserCreateDto;
import com.example.dto.user.UserDetailDto;
import com.example.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id")UUID id){
        UserDetailDto response = userService.get(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> creat(@RequestBody @Valid UserCreateDto user){
      userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")

    public ResponseEntity<?> update(@PathVariable("id")UUID id, @RequestBody UserCreateDto user){
        userService.update(id, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> delete(@PathVariable("id")UUID id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<UserDetailDto> response = userService.getAll();
        return ResponseEntity.ok(response);
    }

}
