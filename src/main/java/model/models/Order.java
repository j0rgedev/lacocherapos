package model.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    @NonNull
    private LocalDateTime date;
    @NonNull
    private double totalAmount;
    private boolean paid;
    @NonNull
    private Client client;
}
