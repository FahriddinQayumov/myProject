package com.example.service;


import com.example.dto.user.UserCreateDto;
import com.example.dto.user.UserDetailDto;
import com.example.enums.UserStatus;
import com.example.exceptions.BadRequest;
import com.example.movieuz.User;
import com.example.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void create (UserCreateDto dto){
        User entity=new User();
        convertDtoEntity(dto,entity);
        LocalDate time=dto.getBirthDate();
        checkDate(time);

        entity.setUserStatus(UserStatus.Inactive);
        entity.setCreatedAt(LocalDateTime.now());

        userRepository.save(entity);
    }

    public UserDetailDto get(UUID id){
        User entity=getEntity(id);
        UserDetailDto dto=new UserDetailDto();
        return convertEntityDto(entity,dto);
    }

    public void update (UUID id , UserCreateDto dto){
        User entity =getEntity(id);

        if(dto.getName()!=null){
            checkString(dto.getName(),"name");
            entity.setName(dto.getName());
        }if (dto.getSurname()!=null){
            checkString(dto.getSurname(),"surname");
            entity.setSurname(dto.getSurname());
        }if (dto.getEmail()!=null){
            entity.setEmail(dto.getEmail());
        }if (dto.getCity()!=null){
            entity.setCity(dto.getCity());
        }if (dto.getBirthDate()!=null){
            checkDate(dto.getBirthDate());
            entity.setBirthDate(dto.getBirthDate());
        }if(dto.getPassword()!=null){
            checkString(dto.getPassword(),"password");
            entity.setPassword(dto.getPassword());
        }if(dto.getGender()!=null){
            entity.setGender(dto.getGender());
        }if(dto.getAddress()!=null){
            checkString(dto.getAddress(),"address");
            entity.setAddress(dto.getAddress());
        }
        userRepository.save(entity);
    }

    public void delete(UUID id){
        getEntity(id);
        userRepository.deleteById(id);
    }

    public List<UserDetailDto> getAll(){
        List<User> users=userRepository.findAll();
        return users.stream().map(user-> convertEntityDto(user,new UserDetailDto())).collect(Collectors.toList());
    }

    public User getEntity(UUID id){
        Optional<User> optional=userRepository.findById(id);
        if(optional.isEmpty()){
            throw new BadRequest("User topilmadi");
        }
        return optional.get();
    }
    private void convertDtoEntity(UserCreateDto dto , User entity){
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setCity(dto.getCity());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPassword(dto.getPassword());
        entity.setGender(dto.getGender());
    }
    private UserDetailDto convertEntityDto(User entity, UserDetailDto dto){
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setCity(entity.getCity());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setBirthDate(entity.getBirthDate());
        dto.setGender(entity.getGender());
        dto.setId(entity.getId());
        dto.setUserStatus(entity.getUserStatus());
        dto.setWallet(entity.getWallet());
        return dto;
    }

    public void changeStatus(UUID id, UserStatus status) {
        User entity=getEntity(id);
        entity.setUserStatus(status);
        entity.setUpdatedAt(LocalDateTime.now());
        userRepository.save(entity);
    }

    public void fillWallet(UUID id, Double money) {
        User entity=getEntity(id);
        entity.setWallet(entity.getWallet()+money);
        entity.setUpdatedAt(LocalDateTime.now());
        userRepository.save(entity);
    }
    private void checkDate(LocalDate time){
        if(time==null){
        } else if (time.isAfter(ChronoLocalDate.from(LocalDate.now()))||
                time.isBefore(ChronoLocalDate.from(LocalDate.now().minusYears(120)))){
            throw new BadRequest("Invalid date");
        }
    }
    private void checkString(String data , String nameOfdata){
        if (data.charAt(0)==' '||data.charAt(data.length()-1)==' '){
            throw new BadRequest(String.format("Invalid %s" ,nameOfdata));
        }
    }
}