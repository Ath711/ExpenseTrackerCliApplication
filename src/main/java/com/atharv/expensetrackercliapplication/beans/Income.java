package com.atharv.expensetrackercliapplication.beans;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Income {
    private int amount;
    private String source;

}
