package lk.ijse.ecommerce.bo.custom.BOImpl;

import lk.ijse.ecommerce.bo.custom.ProductBO;
import lk.ijse.ecommerce.dao.DAOFactory;
import lk.ijse.ecommerce.dao.custom.ProductDAO;
import lk.ijse.ecommerce.dto.categoryDTO;
import lk.ijse.ecommerce.dto.productDTO;
import lk.ijse.ecommerce.entity.Category;
import lk.ijse.ecommerce.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBOImpl implements ProductBO {
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);

    @Override
    public boolean SaveProduct(productDTO productDTO) {
        Category category = new Category(productDTO.getCategory().getCategoryId(), productDTO.getCategory().getName(), productDTO.getCategory().getDescription(), productDTO.getCategory().getImage());
        return productDAO.save(new Product(productDTO.getName(),productDTO.getDescription(),productDTO.getPrice(),productDTO.getStock(),category,productDTO.getImagepath()));
    }

    @Override
    public List<productDTO> getAllProductDTOs() {
        List<Product> allProducts = productDAO.getAllProducts();
        List<productDTO> allProductDTOs = new ArrayList<>();

        for (Product product : allProducts) {
            allProductDTOs.add(
                    new productDTO(
                            product.getProductId(),
                            product.getName(),
                            product.getDescription(),
                            product.getPrice(),
                            product.getStock(),
                    new categoryDTO(
                    product.getCategory().getCategoryId(),
                    product.getCategory().getName(),
                    product.getCategory().getDescription(),
                    product.getCategory().getImage()
            ),
                     product.getImagepath()));
        }
        return allProductDTOs;
    }

    @Override
    public boolean updateProduct(productDTO productDTO) {
        Category category = new Category(productDTO.getCategory().getCategoryId(),productDTO.getCategory().getName(),productDTO.getCategory().getDescription(),productDTO.getCategory().getImage());
        return productDAO.update(new Product(productDTO.getProductId(),productDTO.getName(),productDTO.getDescription(),productDTO.getPrice(),productDTO.getStock(),category,productDTO.getImagepath()));
    }
}
