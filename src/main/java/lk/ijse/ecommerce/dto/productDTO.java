package lk.ijse.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class productDTO {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private categoryDTO category;
    private String imagepath;

    public productDTO(String name, String description, Double price, Integer stock, categoryDTO category, String imagepath) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.imagepath = imagepath;
    }
}
