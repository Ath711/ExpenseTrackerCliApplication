package com.atharv.expensetrackercliapplication;

import com.atharv.expensetrackercliapplication.beans.Expense;
import com.atharv.expensetrackercliapplication.beans.Income;
import com.atharv.expensetrackercliapplication.service.Calculate;
import com.atharv.expensetrackercliapplication.service.ExpenseService;
import com.atharv.expensetrackercliapplication.service.IncomeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.net.CacheRequest;
import java.util.Scanner;

import static com.atharv.expensetrackercliapplication.constant.StringConstant.EXITING_TO_MAIN_MENU;
import static com.atharv.expensetrackercliapplication.constant.StringConstant.INVALID_CHOICE;

@SpringBootApplication
@ComponentScan("com.atharv")
public class ExpenseTrackerCliApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(ExpenseTrackerCliApplication.class, args);
        ExpenseService expenseService = context.getBean(ExpenseService.class);
        IncomeService incomeService = context.getBean(IncomeService.class);
        Calculate calculate = context.getBean(Calculate.class);
        Scanner scanner = new Scanner(System.in);

        boolean mainMenuActive = true;

        while (mainMenuActive) {
            System.out.println();
            System.out.println("1. Select for Income Details Operations");
            System.out.println("2. Select for Expense Details Operations");
            System.out.println("3. Make Calculation for Surplus or Deficit budget");
            System.out.println("4. exit");
            System.out.println();

            int choice = 4;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }

            switch (choice) {
                case 1:
                    boolean incomeMenuActive = true;
                    while (incomeMenuActive) {
                        System.out.println("----INCOME DETAILS----");
                        System.out.println("1. to add income details");
                        System.out.println("2. to remove income details");
                        System.out.println("3. to update income details");
                        System.out.println("4. to show all income details");
                        System.out.println("5. exit to main menu");
                        System.out.println();
                        int caseOneChoice = 5;
                        try {
                            caseOneChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                        switch (caseOneChoice) {

                            case 1:
                                String incomeSource = null;
                                int incomeAmount = 0;

                                System.out.println("enter income amount ");
                                try {
                                    incomeAmount = scanner.nextInt();
                                    scanner.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                System.out.println("enter income source ");
                                incomeSource = scanner.nextLine();

                                incomeService.addIncome(new Income(incomeAmount, incomeSource));

                                System.out.println();
                                break;

                            case 2:
                                System.out.println("enter the index of the income source ");
                                int incomeIndex = 0;

                                try {
                                    incomeIndex = scanner.nextInt();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                incomeService.removeIncome(incomeIndex);

                                System.out.println();
                                break;

                            case 3:
                                String newIncomeSource = null;
                                int newIncomeAmount = 0;
                                int newIncomeIndex = 0;

                                try {
                                    System.out.println("enter the index of income source to update ");
                                    newIncomeIndex = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("enter the updated income amount ");

                                    newIncomeAmount = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("enter the updated income source ");
                                    newIncomeSource = scanner.nextLine();

                                    incomeService.updateIncome(new Income(newIncomeIndex, newIncomeAmount, newIncomeSource));

                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                System.out.println();
                                break;

                            case 4:
                                incomeService.showAllIncome();
                                System.out.println();
                                break;

                            case 5:
                                System.out.println(EXITING_TO_MAIN_MENU);
                                System.out.println();
                                incomeMenuActive = false;
                                break;

                            default:
                                System.out.println(INVALID_CHOICE);
                                System.out.println();
                        }
                    }
                    break;

                case 2:
                    boolean expenseMenuActive = true;
                    while (expenseMenuActive) {
                        System.out.println("----EXPENSE DETAILS----");
                        System.out.println("1. add expense ");
                        System.out.println("2. remove expense");
                        System.out.println("3. update expense");
                        System.out.println("4. show all expense");
                        System.out.println("5. exit to main menu");

                        int caseTwoChoice = 5;
                        try {
                            caseTwoChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        switch (caseTwoChoice) {
                            case 1:
                                int expenseAmount = 0;
                                String expenseCategory = null;
                                String expenseDate = null;
                                String expenseDescription = null;

                                System.out.println("enter the  expense amount ");
                                try {
                                    expenseAmount = scanner.nextInt();
                                    scanner.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                System.out.println("enter the expense category ");
                                expenseCategory = scanner.nextLine();

                                System.out.println("enter the expense date ");
                                expenseDate = scanner.nextLine();

                                System.out.println("enter the expense description ");
                                expenseDescription = scanner.nextLine();

                                expenseService.addExpense(new Expense(expenseAmount, expenseCategory, expenseDate, expenseDescription));

                                System.out.println();
                                break;

                            case 2:
                                System.out.println("enter the index of the expense ");
                                int expenseIndex = 0;

                                try {
                                    expenseIndex = scanner.nextInt();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                expenseService.removeExpense(expenseIndex);

                                System.out.println();
                                break;

                            case 3:
                                int newExpenseAmount = 0;
                                int newExpenseIndex = 0;
                                String newExpenseCategory = null;
                                String newExpenseDate = null;
                                String newExpenseDescription = null;

                                try {
                                    System.out.println("enter the index of expense  to update ");
                                    newExpenseIndex = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("enter the updated expense amount ");

                                    newExpenseAmount = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("enter the updated expense category ");
                                    newExpenseCategory = scanner.nextLine();

                                    System.out.println("enter the updated expense date ");
                                    newExpenseDate = scanner.nextLine();

                                    System.out.println("enter the updated expense description ");
                                    newExpenseDescription = scanner.nextLine();

                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                expenseService.updateExpense(new Expense(newExpenseIndex, newExpenseAmount, newExpenseCategory, newExpenseDate, newExpenseDescription));

                                System.out.println();
                                break;

                            case 4:
                                expenseService.showAllExpense();
                                System.out.println();
                                break;

                            case 5:
                                System.out.println(EXITING_TO_MAIN_MENU);
                                System.out.println();
                                expenseMenuActive = false;
                                break;

                            default:
                                System.out.println(INVALID_CHOICE);
                                System.out.println();
                        }
                    }
                    break;

                case 3:
                    calculate.profitOrLoss();
                    break;

                case 4:
                    System.out.println("exiting..");
                    context.close();
                    scanner.close();
                    return;

                default:
                    System.out.println(INVALID_CHOICE);
                    System.out.println();
            }


        }

    }

}
