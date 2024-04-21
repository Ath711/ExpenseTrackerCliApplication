package com.atharv.expensetrackercliapplication.service;

import com.atharv.expensetrackercliapplication.beans.Income;
import com.atharv.expensetrackercliapplication.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import static com.atharv.expensetrackercliapplication.constant.StringConstant.NO_RECORDS;

@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public void addIncome(int id, Income income) {
        incomeRepository.insert(id, income);
        System.out.println("added successfully..");
    }

    public void removeIncome(int id) {
        if (incomeRepository.checkId(id)) {
            incomeRepository.deleteById(id);
            System.out.println("removed successfully..");
        } else System.out.println(NO_RECORDS);
    }

    public void updateIncome(int id, Income income) {
        if (incomeRepository.checkId(id)) {
            incomeRepository.updateById(id, income);
            System.out.println("updated successfully..");
        } else System.out.println(NO_RECORDS);
    }

    public void showAllIncome() {
        incomeRepository.readALl();
    }
}
