package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dish {
    private String id;
    private String name;
    private double price;
    private String category_id;
}
