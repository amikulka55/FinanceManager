package org.example.service;

import org.example.dao.ExpenseDao;
import org.example.dao.IncomeDao;
import org.example.entity.Expense;
import org.example.entity.Income;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseService {

    private static Expense expense = new Expense();
    private static ExpenseDao expenseDao = new ExpenseDao();


    public static boolean addExpense(BigDecimal kwota, LocalDate dataDodania, String komentarz){
        if(dataDodania != null && kwota != null){
            Income income = new Income(null, kwota, dataDodania,komentarz);
            expenseDao.save(expense);
            return true;
        }
        return false;


    }
}
