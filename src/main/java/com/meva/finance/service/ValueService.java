package com.meva.finance.service;

import com.meva.finance.dto.ValueDto;
import com.meva.finance.model.Church;
import com.meva.finance.model.SubCategory;
import com.meva.finance.model.Value;
import com.meva.finance.repository.CategoryRepository;
import com.meva.finance.repository.SubCategoryRepository;
import com.meva.finance.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ValueService {

    @Autowired
    private ValueRepository valueRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public ResponseEntity<String> register(ValueDto valueDto) {
        String description = valueDto.getCategory();
        SubCategory subCategory = subCategoryRepository.findByDescription(description);
        if (Objects.isNull(subCategory)) {
            return ResponseEntity.badRequest().body("description field not found.");
        }
        Value value = Value.converter(valueDto);
        value.setSubCategory(subCategory);
        balanceChurch(value);
        return ResponseEntity.ok(valueRepository.save(value).getOfferer());
    }

    private void balanceChurch(Value value) {
        String type = value.getType();
        Double amount = value.getValue();
        if (type.equals("e")) {
            Church.deposit(amount);
        }
        if (type.equals("s")) {
            Church.expense(amount);
        }
    }
}