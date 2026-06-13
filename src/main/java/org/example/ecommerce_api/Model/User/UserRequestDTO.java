package org.example.ecommerce_api.Model.User;

import lombok.Data;
import org.aspectj.weaver.AjAttribute;

@Data
public class UserRequestDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
}
