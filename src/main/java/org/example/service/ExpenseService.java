package org.example.service;

import org.example.dao.CategoryDao;
import org.example.dao.ExpenseDao;
import org.example.dao.IncomeDao;
import org.example.dto.ExpenseDto;
import org.example.entity.Category;
import org.example.entity.Expense;
import org.example.entity.Income;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ExpenseService {

    private static Expense expense =new Expense();
    private static ExpenseDao expenseDao = new ExpenseDao();

   private static CategoryDao categoryDao = new CategoryDao();
    public static boolean addExpense(BigDecimal kwota, LocalDate dataDodania, String komentarz, String kategoria){
       Category result = categoryDao.getByName(kategoria);
        if(dataDodania != null && kwota != null){
           Expense expense = new Expense(null,kwota, dataDodania,komentarz,result);
            expenseDao.save(expense);
            return true;
        }
        return false;


    }
    public List<ExpenseDto> getExpenses() {
        List<Expense> expenses = expenseDao.findAll();
        return expenses.stream().map(i -> new ExpenseDto(i.getId(), i.getKwota(), i.getDataDodania(), i.getKomentarz())).toList();
    }

    public void deleteById(int selectedId) {
        if (selectedId > 0) {
            expenseDao.deleteById(selectedId);
        } else {
            throw new IllegalArgumentException("id can not be lower than 0");
        }
}}
