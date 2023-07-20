import com.itextpdf.text.DocumentException;
import model.entity.CartDish;
import model.entity.Client;
import model.entity.Dish;
import model.entity.Order;
import model.utils.ReceiptGenerator;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReceiptGeneratorTest {
    public static void main(String[] args) throws DocumentException, FileNotFoundException {
        Order order = new Order();
        order.setId("B00010");
        order.setDate(LocalDateTime.now());
        order.setTotalAmount(100.00);
        order.setPaid(true);
        order.setClient(new Client("74847426", "Juan", "Perez"));
        List<CartDish> orderDishes = new ArrayList<>();
        for ( int i=0;i<10;i++){
            orderDishes.add(new CartDish(
                    new Dish("D00010", "Ceviche", 20.00, "C01"),
                    1,
                    null
            ));
        }
        ReceiptGenerator.generateReceipt(order, orderDishes);
    }

}
