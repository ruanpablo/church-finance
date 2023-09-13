package com.meva.finance.controller;

import com.meva.finance.dto.CategoryDto;
import com.meva.finance.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CategoryDto category) {
        categoryService.register(category);
        return ResponseEntity.ok("Categoria registrada com sucesso!");
    }
}
