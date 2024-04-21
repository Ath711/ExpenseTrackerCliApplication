package com.atharv.expensetrackercliapplication.service;

import com.atharv.expensetrackercliapplication.beans.Expense;
import com.atharv.expensetrackercliapplication.beans.Income;
import com.atharv.expensetrackercliapplication.repository.ExpenseDataJPA;
import com.atharv.expensetrackercliapplication.repository.IncomeDataJPA;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.atharv.expensetrackercliapplication.constant.StringConstant.NO_RECORDS;

@Service
public class Calculate {
    private ExpenseDataJPA expenseDataJPA;
    private IncomeDataJPA incomeDataJPA;
    private DecimalFormat df = new DecimalFormat("#.##");

    public Calculate(ExpenseDataJPA expenseDataJPA, IncomeDataJPA incomeDataJPA) {
        this.expenseDataJPA = expenseDataJPA;
        this.incomeDataJPA = incomeDataJPA;
    }

    public void budget() {
        int totalIncome = calculateIncomeSum();
        int totalExpense = calculateExpenseSum();

        if (totalIncome != 0 || totalExpense != 0) {
            int balance = totalIncome - totalExpense;
            System.out.println();
            System.out.println("Total Income: " + totalIncome + " Total Expense: " + totalExpense);
            System.out.println();

            if (balance >= 0)
                System.out.println("Surplus: " + balance);
            else
                System.out.println("Deficit: " + balance);
            System.out.println();
            System.out.println("Percentage use: " + percentUsage(totalIncome, totalExpense) + "%");
            System.out.println("Percentage remaining: " + percentRemaining(totalIncome, balance) + "%");
            System.out.println();
            System.out.println(sumByExpenseCategory());
            System.out.println();
        } else {
            System.out.println();
            System.out.println(NO_RECORDS);
        }
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

    private double percentUsage(int totalIncome, int totalExpense) {
        double percentage = 0;
        try {
            percentage = ((double) totalExpense / (double) totalIncome) * 100;
            percentage = Double.parseDouble(df.format(percentage));
        } catch (Exception e) {
            System.out.println(e);
        }
        return percentage;
    }

    private double percentRemaining(int totalIncome, int balance) {
        double percentage = 0;
        try {
            percentage = ((double) balance / (double) totalIncome) * 100;
            percentage = Double.parseDouble(df.format(percentage));
        } catch (Exception e) {
            System.out.println(e);
        }
        return percentage;
    }

    private Map<String, Integer> sumByExpenseCategory() {
        List<Expense> expenses = expenseDataJPA.findAll();
        Map<String, Integer> categorySumMap = new HashMap<>();

        for (Expense e : expenses) {
            String category = e.getCategory();
            int amount = e.getAmount();
            categorySumMap.put(category, categorySumMap.getOrDefault(category, 0) + amount);
        }
        return categorySumMap;
    }

}
