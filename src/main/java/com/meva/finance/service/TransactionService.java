package com.meva.finance.service;

import com.meva.finance.dto.TransactionDto;
import com.meva.finance.model.SubCategory;
import com.meva.finance.model.Transaction;
import com.meva.finance.repository.SubCategoryRepository;
import com.meva.finance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public ResponseEntity<String> register(TransactionDto transactionDto) {
        String description = transactionDto.getCategory();
        SubCategory subCategory = subCategoryRepository.findByDescription(description);
        if (Objects.isNull(subCategory)) {
            return ResponseEntity.badRequest().body("description field not found.");
        }
        Transaction transaction = Transaction.converter(transactionDto);
        transaction.setSubCategory(subCategory);
        return ResponseEntity.ok(transactionRepository.save(transaction).getOfferer());
    }

    public BigDecimal totalBalance(){
        return transactionRepository.calculateTotalBalance();
    }
}