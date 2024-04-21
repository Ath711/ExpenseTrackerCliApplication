package com.atharv.expensetrackercliapplication.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Income {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int amount;
    private String source;

    public Income(int amount, String source) {
        this.amount = amount;
        this.source = source;
    }
}
