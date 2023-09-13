package com.meva.finance.repository;

import com.meva.finance.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT COALESCE(SUM(CASE WHEN c.founds_direction = 'ENTRADA' THEN t.amount ELSE -t.amount END), 0) " +
            "FROM transaction t " +
            "JOIN sub_category sc ON t.sub_category_id = sc.id_sub_category " +
            "JOIN category c ON sc.id_category = c.id_category", nativeQuery = true)
    BigDecimal calculateTotalBalance();

}
