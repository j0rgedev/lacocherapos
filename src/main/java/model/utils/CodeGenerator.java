package model.utils;

public class CodeGenerator {
    // Method to generate a OrderId, which has this format: "B00001"
    public static String generateOrderId(String lastOrderId) {
         String prefix = "B";
         int lastId = Integer.parseInt(lastOrderId.substring(1));
         String suffix = String.format("%05d", lastId + 1);
         return prefix + suffix;
    }
}
