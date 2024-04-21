package com.atharv.expensetrackercliapplication.service;

import com.atharv.expensetrackercliapplication.beans.Income;
import com.atharv.expensetrackercliapplication.repository.IncomeDataJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.atharv.expensetrackercliapplication.constant.StringConstant.NO_RECORDS;

@Service
public class IncomeService {
    private final IncomeDataJPA incomeDataJPA;

    public IncomeService(IncomeDataJPA incomeDataJPA) {
        this.incomeDataJPA = incomeDataJPA;
    }

    public void addIncome(Income income) {
        incomeDataJPA.save(income);
        System.out.println("added successfully..");
    }

    public void removeIncome(int id) {
        Optional<Income> recordAvailable = incomeDataJPA.findById(id);
        if (recordAvailable.isPresent()) {
            try {
                incomeDataJPA.deleteById(id);
                System.out.println("removed successfully..");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else System.out.println(NO_RECORDS);
    }

    public void updateIncome(Income income) {
        Optional<Income> recordAvailable = incomeDataJPA.findById(income.getId());
        if (recordAvailable.isPresent()) {
            try {
                incomeDataJPA.save(income);
                System.out.println("record updated..");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else System.out.println(NO_RECORDS);
    }

    public void showAllIncome() {
        try {
            List<Income> recordAvailable = incomeDataJPA.findAll();
            if (recordAvailable.isEmpty())
                System.out.println(NO_RECORDS);
            else System.out.println(recordAvailable);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
