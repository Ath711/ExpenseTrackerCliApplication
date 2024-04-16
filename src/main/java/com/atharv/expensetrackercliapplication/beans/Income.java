package com.atharv.expensetrackercliapplication.beans;

public class Income {
    private int amount;
    private String source;

    public Income(int amount, String source) {
        this.amount = amount;
        this.source = source;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Income{" +
                "amount=" + amount +
                ", source='" + source + '\'' +
                '}';
    }
}
