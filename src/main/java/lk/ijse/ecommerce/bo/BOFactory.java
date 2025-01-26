package lk.ijse.ecommerce.bo;

import lk.ijse.ecommerce.bo.custom.BOImpl.CategoryBOImpl;
import lk.ijse.ecommerce.bo.custom.BOImpl.ProductBOImpl;
import lk.ijse.ecommerce.bo.custom.BOImpl.loginBOImpl;
import lk.ijse.ecommerce.bo.custom.BOImpl.userBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getBOFactory() {
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        LOGIN,USER, PRODUCT, CATEGORY
    }

    public SuperBO getBO(BOTypes boTypes){

        switch (boTypes){
            case LOGIN:
                return new loginBOImpl();
            case USER:
                return new userBOImpl();
            case CATEGORY:
                return new CategoryBOImpl();
            case PRODUCT:
                return new ProductBOImpl();
            default:
                return null;
        }
    }
}
