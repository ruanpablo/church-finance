package com.meva.finance.model;

import com.meva.finance.dto.ValueDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_value")
    private Long idValue;    private String type;    private String form;
    private String offerer;
    private Double value;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    public static Value converter(ValueDto valueDto) {
        return Value.builder().offerer(valueDto.getOfferer())
                .value(valueDto.getValue()).form(valueDto.getForm()).
                type(valueDto.getType()).dateTime(valueDto.getDateTime()).build();
    }
}
