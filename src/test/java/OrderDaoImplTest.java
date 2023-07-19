import model.dao.impl.OrderDAOImpl;
import model.enums.Category;
import model.service.AdminCharts;
import model.service.LineChartManager;
import view.components.admin.charts.common.ModelChart;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrderDaoImplTest {
    public static void main(String[] args) {
        AdminCharts adminCharts = new AdminCharts();
        List<ModelChart> modelCharts = adminCharts.getDishesQuantityByCategory();
        for (ModelChart modelChart : modelCharts) {
            System.out.println(modelChart.getLabel());
            System.out.println(Arrays.toString(modelChart.getValues()));
        }
    }

}
