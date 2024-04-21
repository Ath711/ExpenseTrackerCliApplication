package com.atharv.expensetrackercliapplication.repository;

import com.atharv.expensetrackercliapplication.beans.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseDataJPA extends JpaRepository<Expense,Integer> {
    List<Expense> findByCategory(String category);
}
