package com.meva.finance.dto;

import com.meva.finance.model.TransferType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionDto {
    private String offerer;
    private String category;
    private TransferType transferType;
    private Double value;
    private LocalDateTime dateTime;
}
