package com.atharv.expensetrackercliapplication.service;

import com.atharv.expensetrackercliapplication.beans.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {
    private List<Expense> expenseList = new ArrayList<>();

    public void addExpense(Expense expense){
        expenseList.add(expense);
    }

    public void removeExpense(int index){
        expenseList.remove(index);
    }

    public void updateExpense(int index, Expense expense){
        expenseList.set(index,expense);
    }

    public List<Expense> showAllExpense(){
        return expenseList;
    }
}
