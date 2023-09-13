package com.meva.finance.dto;

import com.meva.finance.model.FundsDirection;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
public class CategoryDto {
    private String name;
    @Enumerated(EnumType.STRING)
    private FundsDirection foundsDirection;
}
