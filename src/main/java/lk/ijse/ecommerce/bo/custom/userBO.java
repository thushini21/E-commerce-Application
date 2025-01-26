package lk.ijse.ecommerce.bo.custom;

import lk.ijse.ecommerce.bo.SuperBO;
import lk.ijse.ecommerce.dto.userDTO;

import java.util.List;

public interface userBO extends SuperBO {
    boolean saveUser(userDTO userDTO);
    List<userDTO> getAllUsers();

    boolean deactivateUser(int id);

    boolean activateUser(int id);
}
