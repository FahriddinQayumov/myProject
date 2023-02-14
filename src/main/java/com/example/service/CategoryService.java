package com.example.service;

import com.example.controller.Category;
import com.example.repositoryy.CategoryRepository;
import com.example.dto.category.CategoryCreateDto;
import com.example.dto.category.CategoryDetailDto;
import com.example.dto.category.CategoryUpdateDto;
import com.example.exceptions.BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public void create(CategoryCreateDto dto) {
        Category entity=new Category();
        convertDtoToEntity(dto,entity);
        entity.setCreatedAt(LocalDateTime.now());
        categoryRepository.save(entity);
    }

    private Category convertDtoToEntity(CategoryCreateDto dto, Category entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public CategoryDetailDto get(UUID id) {
        CategoryDetailDto dto=new CategoryDetailDto();
        convertEntityToDto(getEntity(id),dto);
        return dto;
    }

    private CategoryDetailDto convertEntityToDto(Category entity, CategoryDetailDto dto) {
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    private Category getEntity (UUID id){
        Optional<Category> optional=categoryRepository.findById(id);
        if(optional.isEmpty()){
            throw new BadRequest("Category topilmadi");
        }
        return optional.get();
    }

    public void update(UUID id, CategoryUpdateDto dto) {
        Category entity=getEntity(id);
        if(dto.getName()!=null){
            entity.setName(dto.getName());
        }if(dto.getDescription()!=null){
            entity.setDescription(dto.getDescription());
        }
        entity.setUpdatedAT(LocalDateTime.now());
    }

    public void delete(UUID id) {
        categoryRepository.delete(getEntity(id));
    }

    public List<CategoryDetailDto> getAll(Integer page, Integer lim) {
        if(page==null||page<0){
            page=0;
        }if(lim==null||lim<1){
            lim=10;
        }
        PageRequest request=PageRequest.of(page,lim);
        Page<Category> categoryPage =categoryRepository.findAll(request);
        List<CategoryDetailDto> dtoList=new LinkedList<>();
        for (Category category :categoryPage) {
            dtoList.add(convertEntityToDto(category,new CategoryDetailDto()));
        }
        return dtoList;
    }
}
