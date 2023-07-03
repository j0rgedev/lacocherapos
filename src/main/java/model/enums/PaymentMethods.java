package model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentMethods {
    CASH("Efectivo"),
    CARD("Tarjeta"),
    EWALLET("Billetera Digital");

    private final String name;
}
