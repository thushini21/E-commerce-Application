package lk.ijse.ecommerce.dao.custom.daoimpl;

import lk.ijse.ecommerce.dao.custom.CategoryDAO;
import lk.ijse.ecommerce.dto.categoryDTO;
import lk.ijse.ecommerce.entity.Category;
import lk.ijse.ecommerce.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public boolean save(Category category) {
        Session session = null;
        Transaction transaction = null;

        try{
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            session.persist(category);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    @Override
    public List<Category> categoryList() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            // Fetching categories from the database
            Query<Category> query = session.createQuery("FROM Category", Category.class);
            List<Category> categoryList = query.list();



            transaction.commit();
            return categoryList;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Category category) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            session.update(category);
            transaction.commit();
            return true;
        }catch (Exception e){
            if (transaction!= null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> categoryNameList() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            // Fetching categories from the database
            Query<Category> query = session.createQuery("SELECT name FROM Category", Category.class);
            List<Category> categoryList = query.list();

            transaction.commit();
            return categoryList;
        }catch (Exception e) {
            if (transaction!= null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category getById(int categoryId) {
        Session session = null;
        Transaction transaction = null;
        Category category = null;

        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            // Fetching categories from the database
            String hql = "FROM Category WHERE id = :id";
            Query<Category> query = session.createQuery(hql, Category.class);

            query.setParameter("id", categoryId);
            category = query.uniqueResult();

            transaction.commit();

        } catch (Exception e) {
            if (transaction!= null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }

    @Override
    public Category getByName(String productCategory) {
        Session session = null;
        Transaction transaction = null;
        Category category = null;

        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            // Fetching categories from the database
            String hql = "FROM category WHERE name = :name";
            Query<Category> query = session.createQuery(hql, Category.class);

            query.setParameter("name", productCategory);
            category = query.uniqueResult();

            transaction.commit();

        } catch (Exception e) {
            if (transaction!= null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;
    }


}
