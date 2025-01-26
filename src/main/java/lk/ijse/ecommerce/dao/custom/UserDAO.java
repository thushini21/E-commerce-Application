package lk.ijse.ecommerce.dao.custom;


import lk.ijse.ecommerce.dao.SuperDAO;
import lk.ijse.ecommerce.entity.User;

import java.util.List;

public interface UserDAO extends SuperDAO {

    // Create a new user
    boolean addUser(User user);

    // Retrieve a user by ID
    User getUserById(int userId);

    // Retrieve all users
    List<User> getAllUsers();

     User verifyUser(String username, String password);

    // Update an existing user
    boolean updateUser(User user);

    // Delete a user by ID
    boolean deactivateUser(int userId);
    boolean activateUser(int userId);
}