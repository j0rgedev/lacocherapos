package model.dto;

public class DashboardDTOS {
    public record AmountProgress(int goalAmount, int currentAmount){}
    public record QuantityProgress(int goalQuantity, int currentQuantity){}
    public record OrdersByPaymentMethod(String orderId, String date, boolean paid, String paymentMethod){}
    public record DishesByCategory(String date, String categoryId, String categoryName, int totalQuantity){}
}


