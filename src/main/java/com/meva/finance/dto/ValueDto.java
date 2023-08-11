package com.meva.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ValueDto {
    private String offerer;
    private String category;
    private String type;
    private String form;
    private Double value;
    private LocalDateTime dateTime;
}
