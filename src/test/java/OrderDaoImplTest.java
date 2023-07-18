import model.dao.impl.OrderDAOImpl;
import model.service.LineChartManager;
import view.components.admin.charts.common.ModelChart;

import java.util.Arrays;
import java.util.List;

public class OrderDaoImplTest {
    public static void main(String[] args) {
        LineChartManager lineChartManager = new LineChartManager(new OrderDAOImpl());
        List<ModelChart> chartData = lineChartManager.generateLineChartData();
        for (ModelChart modelChart : chartData) {
            System.out.println(modelChart.getLabel());
            System.out.println(Arrays.toString(modelChart.getValues()));
        }
    }
}
