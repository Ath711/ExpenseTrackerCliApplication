package com.atharv.expensetrackercliapplication.service;

import com.atharv.expensetrackercliapplication.beans.Expense;
import com.atharv.expensetrackercliapplication.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.atharv.expensetrackercliapplication.constant.StringConstant.NO_RECORDS;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(int id, Expense expense) {
        expenseRepository.insert(id, expense);
        System.out.println("added successfully..");
    }

    public void removeExpense(int id) {
        if (expenseRepository.checkId(id)) {
            expenseRepository.deleteById(id);
            System.out.println("removed successfully..");
        } else System.out.println(NO_RECORDS);
    }

    public void updateExpense(int id, Expense expense) {
        if (expenseRepository.checkId(id)) {
            expenseRepository.updateById(id, expense);
            System.out.println("updated successfully..");
        } else System.out.println(NO_RECORDS);
    }

    public void showAllExpense() {
        expenseRepository.readALl();
    }
}
