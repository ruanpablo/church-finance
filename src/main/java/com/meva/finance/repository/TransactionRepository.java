package com.meva.finance.repository;

import com.meva.finance.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT COALESCE(SUM(CASE WHEN funds_direction = 'ENTRADA' THEN amount ELSE -amount END), 0) FROM value", nativeQuery = true)
    Double calculateTotalBalance();

}
