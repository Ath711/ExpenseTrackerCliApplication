package com.atharv.expensetrackercliapplication.beans;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Expense  {
    private int amount;
    private String category;
    private String date;
    private String description;


}
