package lk.ijse.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
//@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {


    public enum UserRole {
        ADMIN,
        CUSTOMER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role = UserRole.CUSTOMER;

    @Column(nullable = false)
    private Boolean status = true;

    @OneToMany(mappedBy = "user",  fetch = FetchType.EAGER)
    private List<Order> orders;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public User(Long userId, String username, String email, String password, UserRole role, Boolean status) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }
    public User(Long userId){this.userId =userId;

    }
}
