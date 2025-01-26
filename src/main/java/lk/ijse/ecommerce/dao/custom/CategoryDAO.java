package lk.ijse.ecommerce.dao.custom;

import lk.ijse.ecommerce.dao.CrudDAO;
import lk.ijse.ecommerce.entity.Category;

import java.util.List;

public interface CategoryDAO extends CrudDAO<Category> {
    List<Category> categoryList();
    boolean update(Category category);
    List<Category> categoryNameList();


    Category getById(int categoryId);

    Category getByName(String productCategory);

}
