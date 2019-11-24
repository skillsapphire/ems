package com.skillsapphire.service;

import com.skillsapphire.util.ExpenseManagerUtil;
import com.skillsapphire.model.Category;
import com.skillsapphire.model.Expense;
import com.skillsapphire.repository.ExpenseManagerRepository;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

// This is the main operation class
public class ExpenseManagerService {

    private Scanner input = new Scanner(System.in);
    private ExpenseManagerRepository repository = ExpenseManagerRepository.getRepository();
    private static ExpenseManagerService service;

    private ExpenseManagerService(){

    }

    public static ExpenseManagerService getService(){
        if(service == null){
            service = new ExpenseManagerService();
        }
        return service;
    }

    public void addCategory(){
        System.out.print("Enter category name:");
        String catName = input.nextLine();
        Category category = new Category();
        category.setName(catName);
        repository.getCategoryList().add(category);
        System.out.println("Category added successfully!");
    }
    public void showCategories(){
        List<Category> categories = repository.getCategoryList();
        System.out.println("Displaying all categories:");
        for(int i=0; i<categories.size(); i++){
            System.out.println((i+1)+". "+ "Category Id: "+categories.get(i).getCategoryId() +"\t Category Name: "+ categories.get(i).getName());
        }
    }
    public void addExpense(){
        System.out.println("Enter the expense details:");
        showCategories();

        System.out.println("Choose a category from above list:");
        Integer catChoice = input.nextInt();
        Category selectedCategory = repository.getCategoryList().get(catChoice-1);

        System.out.println("Enter amount:");
        Float amount = input.nextFloat();
        // After reading any numeric value there is a new line added to stream so to ignore that new line just add below line
        input.nextLine();

        System.out.println("Enter remark:");
        String remark = input.nextLine();

        System.out.println("Enter date in DD/MM/YYYY(e.g. 15/11/2019) format:");
        String date = input.nextLine();
        Date expenseDate = ExpenseManagerUtil.convertStringToDate(date,"dd/MM/yyyy"); // for 15/11/2019 format refer docs

        Expense expense = new Expense();
        expense.setCategoryId(selectedCategory.getCategoryId());
        expense.setAmount(amount);
        expense.setRemark(remark);
        expense.setDate(expenseDate);

        repository.getExpenseList().add(expense);
        System.out.println("Expense added successfully!");

    }
    public void showExpenses(){
        System.out.println("Showing all expenses: ");
        List<Expense> expenseList = repository.getExpenseList();
        for(int i=0; i<expenseList.size(); i++){
            Expense expense = expenseList.get(i);
            String expenseDate = ExpenseManagerUtil.convertDateToString(expense.getDate(),"dd/MM/yyyy");
            String categoryName = ExpenseManagerUtil.getCategoryNameById(expense.getCategoryId(),repository.getCategoryList());
            System.out.println((i+1)+". "+"Amount: "+expense.getAmount()+", Category: "+categoryName+", Date: "+expenseDate+", Remark: "+expense.getRemark()+", Expense Id: "+expense.getExpenseId());
        }
    }
    public void showMonthlyExpenses(){
        System.out.println("Show monthly expenses in service");
    }
    public void showYearlyExpenses(){
        System.out.println("Show yearly expenses in service");
    }
    public void showCategoryWiseExpenses(){
        System.out.println("Show category wise expenses in service");
    }
    public void closeApplication(){
        System.exit(0);
    }
}
