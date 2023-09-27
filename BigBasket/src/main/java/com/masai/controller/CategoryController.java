package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Category;
import com.masai.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService cService;

  //adminAPI

    
    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category addCategory = cService.addCategory(category);
        return new ResponseEntity<Category> (addCategory,HttpStatus.CREATED.OK);
    }
    
    
  //adminAPIandpaginationandsorting

    @GetMapping("/admin")
    public ResponseEntity<List<Category>> getAllCategoriesAdmin(@RequestParam int page,@RequestParam int size,@RequestParam String sort) {
            
            
        Page<Category> category = cService.getAllCategoriesAdmin(PageRequest.of(page, size, Sort.by(sort)));
        return new ResponseEntity<List<Category>> (category.getContent(),HttpStatus.CREATED.OK);
    }
}