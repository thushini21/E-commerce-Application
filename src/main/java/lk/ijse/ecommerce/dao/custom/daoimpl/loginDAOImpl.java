package lk.ijse.ecommerce.dao.custom.daoimpl;

import lk.ijse.ecommerce.config.FactoryConfiguration;
import lk.ijse.ecommerce.dao.custom.UserDAO;
import lk.ijse.ecommerce.dao.custom.loginDAO;
import lk.ijse.ecommerce.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class loginDAOImpl implements loginDAO {

    @Override
    public User check(String email, String password) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // HQL query to check email and password
            String hql = "FROM user WHERE email = :email AND password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            User user = query.uniqueResult();
            if (user != null) {
                return new User(
                        user.getUserId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getRole(),
                        user.getStatus()
                );
            }
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public boolean save(UserDAO dto) {
        return false;
    }
}
