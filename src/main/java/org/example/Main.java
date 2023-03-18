package org.example;

import org.example.dao.CategoryDao;
import org.example.entity.Category;
import org.example.service.CategoryService;
import org.hibernate.Session;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Session session = DBConnection.getSession();
        session.get(Category.class, 1);
        session.close();

        final CategoryDao categoryDao;
        categoryDao = new CategoryDao();

        CategoryService categoryService = new CategoryService();
        Scanner in = new Scanner(System.in);
        while (true) {

            System.out.println("Wybierz operacje");
            System.out.println("12 - Dodawanie nowej kategorii");


            int decision = in.nextInt();

            switch (decision) {
                case 0 -> {
                    DBConnection.getSession();
                    System.exit(0);
                }
                case 12 -> {
                    try {
                        System.out.println("Podaj nazwę kategorii");
                        in.nextLine();
                        String categoryName = in.nextLine();
                        categoryService.addCategory(categoryName);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }

            }
        }}}