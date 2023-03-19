package org.example.service;

import org.example.DBConnection;
import org.example.dao.CategoryDao;
import org.example.dao.ExpenseDao;
import org.example.dto.ExpenseDto;
import org.example.entity.Category;
import org.example.entity.Expense;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ExpenseService {

    private static Expense expense =new Expense();
    private static ExpenseDao expenseDao = new ExpenseDao();

   private static CategoryDao categoryDao = new CategoryDao();
    public static boolean addExpense(BigDecimal kwota, LocalDate dataDodania, String komentarz, String kategoria){
       Category result = categoryDao.getByName(kategoria);
        if(dataDodania != null && kwota != null&& result!=null){
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
            throw new IllegalArgumentException("Id nie może być mniejsze niż 0");
        }
}
    /*public static List<> findAllExpensesAndIncomes(){
        String hql = " FROM Expense";
        String hql1= "FROM Income";
        Session session = DBConnection.getSession();
        Query query = session.createQuery(hql);
        List<> resultList = query.getResultList();
        session.close();
        return resultList;
    }*/
    public static List<ExpenseDto> findByDate(LocalDate data1, LocalDate data2){
        Session session = DBConnection.getSession();
        Query query = session.createQuery("FROM Expense e WHERE e.dataDodania BETWEEN :p1 AND :p2", Expense.class)
                .setParameter("p1", data1)
                .setParameter("p2", data2);
        List<Expense> resultList = query.getResultList();
        session.close();
        return resultList.stream().map(i -> new ExpenseDto(i.getId(), i.getKwota(), i.getDataDodania(), i.getKomentarz())).toList();
    }

}
