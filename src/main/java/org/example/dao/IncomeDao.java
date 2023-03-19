package org.example.dao;

import org.example.DBConnection;
import org.example.entity.Category;
import org.example.entity.Income;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class IncomeDao {

    private Integer Id;

    public static void save(Income income) {
        Session session = DBConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(income);
        transaction.commit();
        session.close();
    }
    public static List<Income> findAll(){
        String hql = " FROM Income";
        Session session = DBConnection.getSession();
        Query query = session.createQuery(hql);
        List<Income> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    public void deleteById(int selectedId) {
        Session session = DBConnection.getSession();
        Query delete = session.createQuery("DELETE FROM Income i where i.id=:id")
                .setParameter("id", selectedId);
        session.getTransaction().begin();
        delete.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
