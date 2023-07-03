package model.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.enums.PaymentMethods;
import model.enums.PaymentStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String id;
    private PaymentStatus status;
    private PaymentMethods method;
    private int transactionNumber;
    private Order order;
}
