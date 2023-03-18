package org.example.dao;

import org.example.DBConnection;
import org.example.entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDao {
    public void insert(Category category) {
        Session session = DBConnection.getSession();
        session.getTransaction().begin();
        session.persist(category);
        session.getTransaction().commit();
        session.close();
    }

    public static Category getByName(String name){
        String hql = "FROM Category WHERE nazwa = :p1";
        Session session = DBConnection.getSession();
        Query query = session.createQuery(hql);
        query.setParameter("p1",name);
        List<Category> resultList = query.getResultList();
        session.close();

        return  resultList
                .stream()
                .findFirst()
                .orElse(null);
    }


    }

