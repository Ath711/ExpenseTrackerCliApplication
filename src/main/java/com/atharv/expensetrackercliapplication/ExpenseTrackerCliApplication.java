package com.atharv.expensetrackercliapplication;

import com.atharv.expensetrackercliapplication.beans.Expense;
import com.atharv.expensetrackercliapplication.beans.Income;
import com.atharv.expensetrackercliapplication.service.ExpenseService;
import com.atharv.expensetrackercliapplication.service.IncomeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan("com.atharv")
public class ExpenseTrackerCliApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(ExpenseTrackerCliApplication.class, args);
        ExpenseService expenseService = context.getBean(ExpenseService.class);
        IncomeService incomeService = context.getBean(IncomeService.class);
        Scanner scanner = new Scanner(System.in);

        boolean mainMenuActive = true;
        int addIncomeCount = 0;
        int addExpenseCount = 0;

        while (mainMenuActive) {
            System.out.println();
            System.out.println("1. Select for Income Details Operations");
            System.out.println("2. Select for Expense Details Operations");
            System.out.println("3. exit");
            System.out.println();

            int choice = 3;
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

                                try {
                                    incomeService.addIncome(++addIncomeCount, new Income(incomeAmount, incomeSource));
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

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

                                try {
                                    incomeService.removeIncome(incomeIndex);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                System.out.println();
                                break;

                            case 3:
                                String newIncomeSource = null;
                                int newIncomeAmount = 0;
                                int newIncomeIndex = 0;

                                System.out.println("enter the index of income source to update ");
                                try {
                                    newIncomeIndex = scanner.nextInt();
                                    scanner.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                System.out.println("enter the updated income amount ");
                                try {
                                    newIncomeAmount = scanner.nextInt();
                                    scanner.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                System.out.println("enter the updated income source ");
                                newIncomeSource = scanner.nextLine();
                                try {
                                    incomeService.updateIncome(newIncomeIndex, new Income(newIncomeAmount, newIncomeSource));
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
                                System.out.println("exiting to main menu..");
                                System.out.println();
                                incomeMenuActive = false;
                                break;

                            default:
                                System.out.println("invalid choice");
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

                                try {
                                    expenseService.addExpense(++addExpenseCount,new Expense(expenseAmount, expenseCategory, expenseDate, expenseDescription));
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
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

                                try {
                                    expenseService.removeExpense(expenseIndex);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                System.out.println();
                                break;

                            case 3:
                                int newExpenseAmount = 0;
                                int newExpenseIndex = 0;
                                String newExpenseCategory = null;
                                String newExpenseDate = null;
                                String newExpenseDescription = null;

                                System.out.println("enter the index of expense  to update ");
                                try {
                                    newExpenseIndex = scanner.nextInt();
                                    scanner.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                System.out.println("enter the updated expense amount ");
                                try {
                                    newExpenseAmount = scanner.nextInt();
                                    scanner.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }

                                System.out.println("enter the updated expense category ");
                                newExpenseCategory = scanner.nextLine();

                                System.out.println("enter the updated expense date ");
                                newExpenseDate = scanner.nextLine();

                                System.out.println("enter the updated expense description ");
                                newExpenseDescription = scanner.nextLine();

                                try {
                                    expenseService.updateExpense(newExpenseIndex, new Expense(newExpenseAmount, newExpenseCategory, newExpenseDate, newExpenseDescription));
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                System.out.println();
                                break;

                            case 4:
                                expenseService.showAllExpense();
                                System.out.println();
                                break;

                            case 5:
                                System.out.println("exiting to main menu..");
                                System.out.println();
                                expenseMenuActive = false;
                                break;

                            default:
                                System.out.println("invalid choice");
                                System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.println("exiting..");
                    context.close();
                    scanner.close();
                    return;

                default:
                    System.out.println("invalid choice");
                    System.out.println();
            }


        }

    }

}
