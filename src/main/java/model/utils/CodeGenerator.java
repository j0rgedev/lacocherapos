package model.utils;

public class CodeGenerator {
    // Method to generate a OrderId, which has this format: "B00001"
    public static String generateOrderId(String lastOrderId) {
         String prefix = "B";
         int lastId = Integer.parseInt(lastOrderId.substring(1));
         String suffix = String.format("%05d", lastId + 1);
         return prefix + suffix;
    }

    public static String generatePaymentId(String lastPaymentId) {
        String prefix = "P";
        int lastId = Integer.parseInt(lastPaymentId.substring(1));
        String suffix = String.format("%05d", lastId + 1);
        return prefix + suffix;
    }

    public static String generateDishId(String lastDishId){
        String prefix = "DS";
        int lastId = Integer.parseInt(lastDishId.substring(2));
        String suffix = String.format("%03d", lastId + 1);
        return prefix + suffix;
    }

    public static int generateTransactionNumber() {
        return (int) (Math.random() * 1000000);
    }
}
