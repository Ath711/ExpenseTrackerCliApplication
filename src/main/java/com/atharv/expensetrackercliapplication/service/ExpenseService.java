package com.atharv.expensetrackercliapplication.service;

import com.atharv.expensetrackercliapplication.beans.Expense;
import com.atharv.expensetrackercliapplication.repository.ExpenseDataJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.atharv.expensetrackercliapplication.constant.StringConstant.NO_RECORDS;


@Service
public class ExpenseService {
    private final ExpenseDataJPA expenseDataJPA;

    public ExpenseService(ExpenseDataJPA expenseDataJPA) {
        this.expenseDataJPA = expenseDataJPA;
    }

    public void addExpense(Expense expense) {
        try {
            expenseDataJPA.save(expense);
            System.out.println("added successfully..");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void removeExpense(int id) {
        Optional<Expense> recordAvailable = expenseDataJPA.findById(id);
        if (recordAvailable.isPresent()) {
            try {
                expenseDataJPA.deleteById(id);
                System.out.println("record deleted..");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else System.out.println(NO_RECORDS);
    }

    public void updateExpense(Expense expense) {
        Optional<Expense> recordAvailable = expenseDataJPA.findById(expense.getId());
        if (recordAvailable.isPresent()) {
            try {
                expenseDataJPA.save(expense);
                System.out.println("record updated..");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else System.out.println(NO_RECORDS);
    }

    public void showAllExpense() {
        try {
            List<Expense> recordAvailable = expenseDataJPA.findAll();
            if (recordAvailable.isEmpty()) System.out.println(NO_RECORDS);
            else System.out.println(recordAvailable);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
