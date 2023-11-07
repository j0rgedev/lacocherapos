package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.enums.Roles;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String id;
    private String names;
    private String lastNames;
    private String password;
    private String salt;
    private Roles role;
}
