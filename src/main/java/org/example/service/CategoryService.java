package org.example.service;

import org.example.DBConnection;
import org.example.dao.CategoryDao;
import org.example.entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.w3c.dom.ls.LSOutput;

import java.util.List;


public class CategoryService {


    private static final CategoryDao categoryDao = new CategoryDao();


    public void addCategory(String categoryName) {
        if (categoryName != null && existByName(categoryName) && categoryName.length() > 2) {
            Category category = new Category(null, categoryName);
            category.setNazwa(categoryName);
            categoryDao.insert(category);
        } else {
            throw new IllegalArgumentException("Nazwa kategorii nie może być pusta, nie może być krótsza niż 3 znaki lub podana kategoria już istnieje");
        }
    }

    public static boolean existByName(String categoryName) {
        return categoryDao.getByName(categoryName) == null;
    }

    /**
     * Wyświetl wszystkie nazwy kategorii użytkownikowi, tak aby wiedział którą usunąć.
     * W tym celu wywołaj metodę getAllNames z CategoryServices. Metoda
     * getAllNames, wywołuje metodę getAllNames z CategoryDao, która za pomocą HQL
     * wyszukuje wszystkie nazwy kategorii. Metody powinny zwracać listę String.
     */
    public static List<String> getAllNames() {
        String hql = " FROM Category";
        Session session = DBConnection.getSession();
        Query query = session.createQuery(hql);
        List<Category> resultList = query.getResultList();
        System.out.println(resultList);
        session.close();
        return (List<String>) resultList
                .stream()
                .onClose(null);

    }

    public void deleteCategory(String categoryName) {
        if (categoryName != null && existByName(categoryName)) {
            Category category = new Category(null, categoryName);
            category.setNazwa(categoryName);
            categoryDao.delete(category);
            throw new IllegalArgumentException("Nazwa kategorii nie może być pusta, nie może być krótsza niż 3 znaki lub podana kategoria już istnieje");

 }

    }
}
