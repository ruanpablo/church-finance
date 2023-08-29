package com.meva.finance.model;

import javax.persistence.*;

@Entity
@Table(name = "sub_category")
public class SubCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_category")
    private Long idSubCategory;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
