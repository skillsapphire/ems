package com.skillsapphire.repository;

import com.skillsapphire.model.Category;
import com.skillsapphire.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManagerRepository {

    private List<Category> categoryList = new ArrayList<>();
    private List<Expense> expenseList = new ArrayList<>();

    private static ExpenseManagerRepository repository;

    // Make it singleton to avoid multiple creation of repository object
    private ExpenseManagerRepository(){

    }

    public static ExpenseManagerRepository getRepository(){
        if(repository == null) {
            repository = new ExpenseManagerRepository();
        }
        return repository;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
}
