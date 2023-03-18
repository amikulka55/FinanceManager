package org.example.dao;

import org.example.DBConnection;
import org.example.entity.Income;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IncomeDao {

    private Integer Id;

    public static void save(Income income) {
        Session session = DBConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(income);
        transaction.commit();
        session.close();
    }
}
