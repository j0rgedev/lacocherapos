package model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentStatus {
    PAID("Pagado"),
    PENDING("Pendiente"),
    CANCELED("Cancelado");

    private final String name;
}
