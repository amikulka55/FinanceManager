package org.example.dao;

import org.example.DBConnection;
import org.example.entity.Category;
import org.hibernate.Session;

public class CategoryDao {
    public void insert(Category category) {
        Session session = DBConnection.getSession();
        session.getTransaction().begin();
        session.persist(category);
        session.getTransaction().commit();
        session.close();
    }


    public void save(Category category) {
    }
}
