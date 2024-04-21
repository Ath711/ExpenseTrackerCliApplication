package com.atharv.expensetrackercliapplication.service;

import com.atharv.expensetrackercliapplication.beans.Expense;
import com.atharv.expensetrackercliapplication.beans.Income;
import com.atharv.expensetrackercliapplication.repository.ExpenseDataJPA;
import com.atharv.expensetrackercliapplication.repository.IncomeDataJPA;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.atharv.expensetrackercliapplication.constant.StringConstant.NO_RECORDS;

@Service
public class Calculate {
    private ExpenseDataJPA expenseDataJPA;
    private IncomeDataJPA incomeDataJPA;

    public Calculate(ExpenseDataJPA expenseDataJPA, IncomeDataJPA incomeDataJPA) {
        this.expenseDataJPA = expenseDataJPA;
        this.incomeDataJPA = incomeDataJPA;
    }

    private int calculateExpenseSum() {
        List<Expense> expense = expenseDataJPA.findAll();
        int expenseSum = 0;
        for (Expense e : expense) {
            expenseSum += e.getAmount();
        }
        return expenseSum;
    }

    private int calculateIncomeSum() {
        List<Income> income = incomeDataJPA.findAll();
        int incomeSum = 0;
        for (Income i : income) {
            incomeSum += i.getAmount();
        }
        return incomeSum;
    }

    public void profitOrLoss() {
        int totalIncome = calculateIncomeSum();
        int totalExpense = calculateExpenseSum();
        if (totalIncome == 0 && totalExpense == 0) {
            System.out.println();
            System.out.println(NO_RECORDS);
        } else {
            int balance = totalIncome - totalExpense;
            System.out.println();
            System.out.println("Total Income: " + totalIncome + " Total Expense: " + totalExpense);
            System.out.println();
            if (balance >= 0) System.out.println("Surplus: " + balance);
            else System.out.println("Deficit: " + balance);
        }
    }
}
