package com.sof3011.hangnt169.B10_Hibernate.repository;

import com.sof3011.hangnt169.B10_Hibernate.config.HibernateConfig;
import com.sof3011.hangnt169.B10_Hibernate.entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryRepository {

    // CRUD => CREATE + READ + UPDATE + DELETE
    // GET ALL
    public List<Category> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Category> lists = session.createQuery("FROM Category").list();
        session.close();
        return lists;
    }

    // Get one
    public Category getOne(Long id) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Category c = (Category) session.createQuery("FROM Category WHERE id1 =:id").getSingleResult();
        session.close();
        return c;
    }

    // Add
    public boolean add(Category category) {
        Transaction tra = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            tra = s.beginTransaction();
            s.persist(category); // Add
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // Update
    public boolean update(Category category) {
        Transaction tra = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            tra = s.beginTransaction();
            s.merge(category); // Update
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // Delete
    public boolean delete(Category category) {
        Transaction tra = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            tra = s.beginTransaction();
            s.delete(category); // Delete
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
    }
}
