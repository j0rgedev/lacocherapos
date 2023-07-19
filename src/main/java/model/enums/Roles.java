package model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Roles {
    MANAGER("manager"),
    CASHIER("cashier"),
    WAITER("waiter"),
    CHEF("chef");

    private final String roleName;
}
