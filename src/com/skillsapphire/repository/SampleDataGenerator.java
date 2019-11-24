package com.skillsapphire.repository;

import com.skillsapphire.model.Category;

public class SampleDataGenerator {

    private ExpenseManagerRepository repository =  ExpenseManagerRepository.getRepository();

    public void prepareSampleData(){
        Category food = new Category();
        food.setName("Food");
        repository.getCategoryList().add(food);

        Category sports = new Category();
        sports.setName("Sports");
        repository.getCategoryList().add(sports);

        Category utility = new Category();
        utility.setName("Utility bills");
        repository.getCategoryList().add(utility);


    }
}
