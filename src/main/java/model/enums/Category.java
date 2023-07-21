package model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    CARTA("Carta", "C01"),
    ANTOJITOS("Antojitos","C02"),
    BEBIDAS_CALIENTES("Bebidas calientes","C03"),
    BEBIDAS_FRIAS("Bebidas frias","C04"),
    TRAGOS("Tragos","C05"),
    CERVEZAS("Cervezas","C06"),
    POSTRES("Postres","C07");

    private final String name;
    private final String id;

    public static Category getCategoryById(String id){
        for (Category category : Category.values()) {
            if(category.getId().equals(id)){
                return category;
            }
        }
        return null;
    }

    public static Category getCategoryByName(String name){
        for (Category category : Category.values()) {
            if(category.getName().equals(name)){
                return category;
            }
        }
        return null;
    }
}
