package com.meva.finance.service;

import com.meva.finance.dto.CategoryDto;
import com.meva.finance.model.Category;
import com.meva.finance.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void register(CategoryDto dto){
        categoryRepository.save(Category.converter(dto));
    }
}
