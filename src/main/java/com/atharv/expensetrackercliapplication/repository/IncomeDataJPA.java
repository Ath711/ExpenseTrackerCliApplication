package com.atharv.expensetrackercliapplication.repository;

import com.atharv.expensetrackercliapplication.beans.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeDataJPA extends JpaRepository<Income,Integer> {
}
