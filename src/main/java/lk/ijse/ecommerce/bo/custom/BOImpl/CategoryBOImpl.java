package lk.ijse.ecommerce.bo.custom.BOImpl;

import lk.ijse.ecommerce.bo.custom.CategoryBO;
import lk.ijse.ecommerce.dao.DAOFactory;
import lk.ijse.ecommerce.dao.custom.CategoryDAO;
import lk.ijse.ecommerce.dto.categoryDTO;
import lk.ijse.ecommerce.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryBOImpl implements CategoryBO {
    CategoryDAO categoryDAO = (CategoryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CATEGORY);
    @Override
    public boolean SaveCategory(String categoryName, String description, String image) {
        return categoryDAO.save(new Category(categoryName, description, image));
    }

    @Override
    public List<categoryDTO> categoryList() {
        List<Category> all = categoryDAO.categoryList();
        List<categoryDTO> allCategories = new ArrayList();
        for (Category category : all) {
            allCategories.add(new categoryDTO(category.getCategoryId(),category.getName(),category.getDescription(),category.getImage()));
        }
        return allCategories;
    }

    @Override
    public boolean updateCategory(categoryDTO category) {
        return categoryDAO.update(new Category(category.getName(),category.getDescription()));
    }

    @Override
    public List<categoryDTO> getAllCategoryNames() {
        List<Category> all = categoryDAO.categoryNameList();
        List<categoryDTO> allCategories = new ArrayList<>();
        for (Category category : all) {
            allCategories.add(new categoryDTO(category.getName()));
        }
        return allCategories;
    }

    @Override
    public categoryDTO getById(int categoryId) {
        Category category = categoryDAO.getById(categoryId);
        return new categoryDTO(category.getCategoryId(), category.getName(), category.getDescription(), category.getImage());
    }

    @Override
    public categoryDTO getByName(String productCategory) {
        Category category = categoryDAO.getByName(productCategory);
        return new categoryDTO(category.getCategoryId(), category.getName(), category.getDescription(), category.getImage());

    }
}

