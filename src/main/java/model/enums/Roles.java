package model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Roles {
    MANAGER("administrador"),
    CASHIER("cajero"),
    WAITER("mozo"),
    CHEF("chef");

    private final String roleName;

    public static Roles getRole(String roleName) {
        for (Roles role : Roles.values()) {
            if (role.getRoleName().equals(roleName)) {
                return role;
            }
        }
        return null;
    }
}
