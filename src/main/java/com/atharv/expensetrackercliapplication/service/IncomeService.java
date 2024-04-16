package com.atharv.expensetrackercliapplication.service;

import com.atharv.expensetrackercliapplication.beans.Income;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeService {
    private List<Income> incomeList = new ArrayList<>();

    public void addIncome(Income income){
        incomeList.add(income);
    }

    public void removeIncome(int index){
        incomeList.remove(index);
    }

    public void updateIncome(int index, Income income){
        incomeList.set(index,income);
    }

    public List<Income> showAllIncome(){
        return incomeList;
    }
}
