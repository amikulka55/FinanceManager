package org.example.service;

import org.example.dao.CategoryDao;
import org.example.entity.Category;


public class CategoryService {


private static final CategoryDao categoryDao = new CategoryDao();


    public void addCategory(String categoryName) {
        if (categoryName != null && !Category.existByCategory(categoryName) && categoryName.length() > 2) {
            Category category = new Category(null, categoryName);
            category.setNazwa(categoryName);
            categoryDao.insert(category);
        } else {
            throw new IllegalArgumentException("Nazwa kategorii nie może być pusta, nie może być krótsza niż 3 znaki lub podana kategoria już istnieje");
        }
    }

        public void deleteCategory (String categoryName){

        }
}
