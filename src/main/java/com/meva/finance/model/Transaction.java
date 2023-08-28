package com.meva.finance.model;

import com.meva.finance.dto.TransactionDto;
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
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_value")
    private Long idValue;
    @Enumerated(EnumType.STRING)
    private FundsDirection fundsDirection;
    @Enumerated(EnumType.STRING)
    private TransferType transferType;
    private String offerer;
    private Double amount;
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    public static Transaction converter(TransactionDto valueDto) {
        return com.meva.finance.model.Transaction.builder().offerer(valueDto.getOfferer())
                .amount(valueDto.getValue()).transferType(valueDto.getTransferType()).
                fundsDirection(valueDto.getFundsDirection()).dateTime(valueDto.getDateTime()).build();
    }

}
