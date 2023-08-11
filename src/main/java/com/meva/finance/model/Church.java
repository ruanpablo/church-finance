package com.meva.finance.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class Church {

    @Getter @Setter
    private static Double totalBalance;
    @Getter @Setter
    private static String name;

    public static void deposit(Double value) {
        totalBalance += value;
    }

    public static void expense(Double value) {
        totalBalance -= value;
    }
}
