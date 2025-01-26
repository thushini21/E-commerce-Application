package lk.ijse.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class categoryDTO {
    private int categoryId;
    private String name;
    private String description;
    private String image;

    public categoryDTO(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
    public categoryDTO(String categoryName, String description) {
        this.name = categoryName;
        this.description = description;
    }

    public categoryDTO(int id, String categoryName, String description) {
        this.categoryId = id;
        this.name = categoryName;
        this.description = description;
    }

    public categoryDTO(String name) {
        this.name = name;
    }


}
