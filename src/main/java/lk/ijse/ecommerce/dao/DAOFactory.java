package lk.ijse.ecommerce.dao;

import lk.ijse.ecommerce.dao.custom.daoimpl.CategoryDAOImpl;
import lk.ijse.ecommerce.dao.custom.daoimpl.ProductDAOImpl;
import lk.ijse.ecommerce.dao.custom.daoimpl.loginDAOImpl;
import lk.ijse.ecommerce.dao.custom.daoimpl.userDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getDAOFactory() {
        return daoFactory == null ? daoFactory= new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        LOGIN,USER,CATEGORY,PRODUCT
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case LOGIN:
                return new loginDAOImpl();
            case USER:
                return new userDAOImpl();
            case CATEGORY:
                return new CategoryDAOImpl();
            case PRODUCT:
                return new ProductDAOImpl();
            default:
                return null;
        }
    }
}
