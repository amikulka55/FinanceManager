package org.example.dao;

import org.example.DBConnection;
import org.example.entity.Expense;
import org.example.entity.Income;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ExpenseDao {

    private Integer Id;
    public static void save(Expense expense) {
        Session session = DBConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(expense);
        transaction.commit();
        session.close();
    }
    public static List<Expense> findAll(){
        String hql = " FROM Expense";
        Session session = DBConnection.getSession();
        Query query = session.createQuery(hql);
        List<Expense> resultList = query.getResultList();
        session.close();
        return resultList;
    }

}


