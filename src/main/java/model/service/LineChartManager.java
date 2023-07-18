package model.service;

import model.dao.impl.OrderDAOImpl;
import model.dto.DashboardDTOS;
import view.components.admin.charts.common.ModelChart;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LineChartManager {
    OrderDAOImpl orderDAO;

    public LineChartManager(OrderDAOImpl orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<ModelChart> generateLineChartData() {
        List<DashboardDTOS.OrdersByPaymentMethod> orders = orderDAO.getOrdersQuantityByPaymentMethod();
        LocalDate currentDate = LocalDate.now();
        List<YearMonth> yearMonthList = getLastSixMonths(currentDate);
        Map<YearMonth, Map<String, Integer>> ordersByMonthAndPaymentMethod = getOrdersByMonthAndPaymentMethod(orders, yearMonthList);
        return calculateLineChartData(ordersByMonthAndPaymentMethod);
    }

    private List<YearMonth> getLastSixMonths(LocalDate currentDate) {
        List<YearMonth> months = new ArrayList<>();
        for (int i = 5; i >= 0; i--) {
            YearMonth mes = YearMonth.from(currentDate.minusMonths(i));
            months.add(mes);
        }
        return months;
    }

    private Map<YearMonth, Map<String, Integer>> getOrdersByMonthAndPaymentMethod(List<DashboardDTOS.OrdersByPaymentMethod> orders, List<YearMonth> yearMonthList
    ) {
        Map<YearMonth, Map<String, Integer>> ordersByMonthAndPaymentMethod = new HashMap<>();

        for (YearMonth yearMonth : yearMonthList) {
            Map<String, Integer> paymentMethodsCount = new HashMap<>();
            for (DashboardDTOS.OrdersByPaymentMethod order : orders) {
                YearMonth orderDate = YearMonth.parse(order.date(), DateTimeFormatter.ofPattern("yyyy-MM"));
                if (orderDate.equals(yearMonth)) {
                    String paymentMethod = order.paymentMethod()==null ? "Not paid" : order.paymentMethod();
                    paymentMethodsCount.put(paymentMethod, paymentMethodsCount.getOrDefault(paymentMethod, 0) + 1);
                }
            }
            ordersByMonthAndPaymentMethod.put(yearMonth, paymentMethodsCount);
        }

        return ordersByMonthAndPaymentMethod;
    }

    private List<ModelChart> calculateLineChartData(Map<YearMonth, Map<String, Integer>> orders) {
        List<ModelChart> chartData = new ArrayList<>();

        for (Map.Entry<YearMonth, Map<String, Integer>> entry : orders.entrySet()) {
            YearMonth mes = entry.getKey();
            Map<String, Integer> paymentMethodCount = entry.getValue();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", new Locale("es", "ES"));
            String monthName = mes.format(formatter);
            monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1);

            double[] monthData = new double[3];
            monthData[0] = paymentMethodCount.getOrDefault("Efectivo", 0);
            monthData[1] = paymentMethodCount.getOrDefault("Tarjeta", 0);
            monthData[2] = paymentMethodCount.getOrDefault("Billetera digital", 0);

            chartData.add(new ModelChart(monthName, monthData));
        }

        return chartData;
    }

}
