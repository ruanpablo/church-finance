package com.meva.finance.repository;

import com.meva.finance.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    SubCategory findByDescription(String description);
}
