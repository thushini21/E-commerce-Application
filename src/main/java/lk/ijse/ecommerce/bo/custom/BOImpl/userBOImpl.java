package lk.ijse.ecommerce.bo.custom.BOImpl;

import lk.ijse.ecommerce.bo.custom.userBO;
import lk.ijse.ecommerce.dao.custom.UserDAO;
import lk.ijse.ecommerce.dao.custom.daoimpl.userDAOImpl;
import lk.ijse.ecommerce.dto.userDTO;
import lk.ijse.ecommerce.entity.User;

import java.util.ArrayList;
import java.util.List;


public class userBOImpl implements userBO {
    UserDAO userDAO = new userDAOImpl();

    @Override
    public boolean saveUser(userDTO userDTO) {
        return userDAO.addUser(new User(userDTO.getUsername(), userDTO.getEmail(),userDTO.getPassword()));
    }

    @Override
    public List<userDTO> getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        List<userDTO> allUsers = new ArrayList<>();
        for(User user:users){
            allUsers.add(new userDTO(user.getUserId(),user.getUsername(),user.getEmail(),user.getPassword(),user.getRole(),user.getStatus()
            ));
        }
        return allUsers;
    }

    @Override
    public boolean deactivateUser(int id) {

        return userDAO.deactivateUser(id);
    }

    @Override
    public boolean activateUser(int id) {

        return userDAO.activateUser(id);
    }
}
