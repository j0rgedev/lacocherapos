package model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    CARTA("C01"),
    ANTOJITOS("C02"),
    BEBIDAS_CALIENTES("C03"),
    BEBIDAS_FRIAS("C04"),
    CERVEZA("C05"),
    TRAGOS("C06"),
    POSTRES("C07");

    private final String id;
}
