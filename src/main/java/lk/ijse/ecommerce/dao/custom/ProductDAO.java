package lk.ijse.ecommerce.dao.custom;

import lk.ijse.ecommerce.dao.SuperDAO;
import lk.ijse.ecommerce.entity.Product;

import java.util.List;

public interface ProductDAO extends SuperDAO {
    boolean save(Product product);
    List<Product> getAllProducts();

    boolean update(Product product);
}
