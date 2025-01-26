package lk.ijse.ecommerce.dto;

import lk.ijse.ecommerce.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class userDTO {
    private Long userId;
    private String username;
    private String email;
    private String password;
    private User.UserRole role = User.UserRole.CUSTOMER;
    private Boolean status;

    public userDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public userDTO(String userId){
        this.userId=Long.parseLong(userId);
    }
}
