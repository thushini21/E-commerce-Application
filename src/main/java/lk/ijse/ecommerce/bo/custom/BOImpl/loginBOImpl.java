package lk.ijse.ecommerce.bo.custom.BOImpl;

import lk.ijse.ecommerce.bo.custom.LoginBO;
import lk.ijse.ecommerce.dao.DAOFactory;
import lk.ijse.ecommerce.dao.custom.loginDAO;
import lk.ijse.ecommerce.entity.User;


public class loginBOImpl implements LoginBO {
    loginDAO loginDAO = (lk.ijse.ecommerce.dao.custom.loginDAO) DAOFactory.getDAOFactory().getDAOFactory().getDAO(DAOFactory.DAOTypes.LOGIN);
    public User cheackEmail(String email, String password) {

        return loginDAO.check(email,password);
    }
}
