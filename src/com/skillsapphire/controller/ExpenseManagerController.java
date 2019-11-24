package com.skillsapphire.controller;

import com.skillsapphire.service.ExpenseManagerService;

import java.util.Scanner;

public class ExpenseManagerController {

    private Scanner input = new Scanner(System.in);
    private Integer userInput;

    private ExpenseManagerService service = ExpenseManagerService.getService();

    public void displayMenu(){
        while (true){
            createMenuOptions();
            switch (userInput){
                case 1:
                    service.addCategory();
                    pressEnterToContinue();
                    break;
                case 2:
                    service.showCategories();
                    pressEnterToContinue();
                    break;
                case 3:
                    service.addExpense();
                    pressEnterToContinue();
                    break;
                case 4:
                    service.showExpenses();
                    pressEnterToContinue();
                    break;
                case 5:
                    service.showMonthlyExpenses();
                    pressEnterToContinue();
                    break;
                case 6:
                    service.showYearlyExpenses();
                    pressEnterToContinue();
                    break;
                case 7:
                    service.showCategoryWiseExpenses();
                    pressEnterToContinue();
                    break;
                case 0:
                    service.closeApplication();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    pressEnterToContinue();
                    break;
            }
        }
    }

    public void createMenuOptions(){
        System.out.println("======== Expense Manager Menu ========");
        System.out.println("1. Add a category");
        System.out.println("2. Display all category");
        System.out.println("3. Add a new expense");
        System.out.println("4. Display all expense");
        System.out.println("5. Reporting: Monthly expenses");
        System.out.println("6. Reporting: Yearly expenses");
        System.out.println("7. Reporting: Category wise expenses");
        System.out.println("0. Close application");
        System.out.println("======================================");
        System.out.print("Enter your choice: ");
        userInput = input.nextInt();
    }

    public void pressEnterToContinue(){
        try{
            System.out.println("Press Enter key to continue...");
            System.in.read();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
