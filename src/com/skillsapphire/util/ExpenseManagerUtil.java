package com.skillsapphire.util;

import com.skillsapphire.model.Category;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExpenseManagerUtil {

    public static String getCategoryNameById(Long categoryId, List<Category> categories){
        String categoryName = null;
        for(Category category: categories){
            if(category.getCategoryId() == categoryId){
                categoryName = category.getName();
                return categoryName;
            }
        }
        return null;
    }

    public static Date convertStringToDate(String dateInString, String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateInString);
        }catch (ParseException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static String convertDateToString(Date date, String format){
         SimpleDateFormat sdf = new SimpleDateFormat(format);
         return  sdf.format(date);
    }
}
