package lk.ijse.ecommerce.dao.custom;

import lk.ijse.ecommerce.dao.CrudDAO;
import lk.ijse.ecommerce.entity.User;

public interface loginDAO extends CrudDAO<UserDAO> {
    public User check(String email, String password);
}
