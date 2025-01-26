package lk.ijse.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.font.TextHitInfo;

@Entity
//@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String description;

    @Column(nullable = false, unique = true)
    private String image;

    public Category(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
    public Category(int categoryId, String name, String description){
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;

    }

    public Category(String name){
        this.name=name;

    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
//
//    public Category(String name, String description) {
//
//    }
}
