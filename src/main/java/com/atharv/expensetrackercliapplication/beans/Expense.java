package com.atharv.expensetrackercliapplication.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Expense  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int amount;
    private String category;
    private String date;
    private String description;
    public Expense(int amount, String category, String date, String description) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }
}
