package lk.ijse.ecommerce.bo.custom;

import lk.ijse.ecommerce.bo.SuperBO;
import lk.ijse.ecommerce.entity.User;

public interface LoginBO extends SuperBO {
    User cheackEmail(String email, String password);
}
