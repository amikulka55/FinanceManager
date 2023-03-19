package org.example;

import org.example.dao.CategoryDao;
import org.example.dto.IncomeDto;
import org.example.entity.Category;
import org.example.service.CategoryService;
import org.example.service.IncomeService;
import org.hibernate.Session;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Session session = DBConnection.getSession();
        session.get(Category.class, 1);
        session.close();

        final CategoryDao categoryDao;
        categoryDao = new CategoryDao();

        CategoryService categoryService = new CategoryService();
        IncomeService incomeService = new IncomeService();
        Scanner in = new Scanner(System.in);
        while (true) {

            System.out.println("Wybierz operacje");
            System.out.println("3 - Dodwawanie nowego przychodu");
            System.out.println("4 - Usuwanie przychodu");
            System.out.println("10 - Wyświetlanie wszystkich przychodów");
            System.out.println("12 - Dodawanie nowej kategorii");
            System.out.println("13 - Usuwanie kategorii");


            int decision = in.nextInt();

            switch (decision) {
                case 0 -> {
                    DBConnection.getSession();
                    System.exit(0);
                }
                case 3 -> {
                    try {
                        System.out.println("Podaj kwotę: ");
                        BigDecimal kwota = in.nextBigDecimal();

                        System.out.println("Podaj datę dodania: ");
                        LocalDate dataDodania = LocalDate.parse(in.next());

                        System.out.println("Dodaj komentarz: ");
                        String komentarz= in.next();


                        boolean result = incomeService.addIncome(kwota, dataDodania,komentarz);

                        if (result) {
                            System.out.println("Pomyślnie utworzono przychód");
                        } else {
                            System.out.println("Nie utworzono przychodu");
                        }
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 4 -> {
                    List<IncomeDto> incomes = incomeService.getIncomes();

                    System.out.println("Wybierz przychód do usunięcia");
                    incomes.forEach(System.out::println);
                    int selectedId = in.nextInt();
                    try {
                        incomeService.deleteById(selectedId);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 10-> {
                    List<IncomeDto> incomes = incomeService.getIncomes();
                    incomes.forEach(System.out::println);
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
                case 13 -> {
                    try {
                        System.out.println(CategoryService.getAllNames());
                        System.out.println("Wpisz nazwę kategorii do usunięcia");
                        in.nextLine();
                        String categoryName = in.nextLine();
                        categoryService.deleteCategory(categoryName);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }

            }
        }


    }
}