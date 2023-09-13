package com.meva.finance.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.meva.finance.config.CustomLocalDateTimeDeserializer;
import com.meva.finance.model.TransferType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionDto {
    private String offerer;
    private String category;
    private TransferType transferType;
    private BigDecimal value;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;
}
