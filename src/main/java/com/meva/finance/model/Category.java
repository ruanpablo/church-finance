package com.meva.finance.model;

import com.meva.finance.dto.CategoryDto;
import lombok.Builder;

import javax.persistence.*;

@Builder
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;
    private String name;
    @Enumerated(EnumType.STRING)
    private FundsDirection foundsDirection;


    public static Category converter(CategoryDto data){
        return Category.builder().name(data.getName()).foundsDirection(data.getFoundsDirection()).build();
    }

}
