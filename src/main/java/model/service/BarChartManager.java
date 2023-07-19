package model.service;

import model.dao.impl.OrderDAOImpl;
import model.dto.DashboardDTOS;
import model.enums.Category;
import view.components.admin.charts.common.ModelChart;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BarChartManager {
    private final OrderDAOImpl orderDAO;
    public BarChartManager(OrderDAOImpl orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<ModelChart> generateBarChartData(List<YearMonth> yearMonthList) {
        List<DashboardDTOS.DishesByCategory> dishesByCategoryList = orderDAO.getDishesQuantityByCategory();
        return calculateBarChartData(dishesByCategoryList, yearMonthList);
    }

    private List<ModelChart> calculateBarChartData(List<DashboardDTOS.DishesByCategory> dishesByCategoryList,
                                                   List<YearMonth> yearMonthList) {
        Map<String, double[]> dataMap = groupDataByMonth(dishesByCategoryList);
        return createChartData(dataMap, yearMonthList);
    }

    private Map<String, double[]> groupDataByMonth(List<DashboardDTOS.DishesByCategory> dishesByCategoryList) {
        Map<String, double[]> dataMap = new LinkedHashMap<>();
        for (DashboardDTOS.DishesByCategory dish : dishesByCategoryList) {
            String categoryId = dish.categoryId();
            double amount = dish.totalQuantity();
            int categoryIndex = getCategoryIndex(categoryId);
            if (categoryIndex != -1) {
                YearMonth yearMonth = YearMonth.parse(dish.date());
                String month = yearMonth.toString();
                double[] amounts = dataMap.getOrDefault(month, new double[7]);
                amounts[categoryIndex] = amount;
                dataMap.put(month, amounts);
            }
        }
        return dataMap;
    }

    private List<ModelChart> createChartData(Map<String, double[]> dataMap, List<YearMonth> yearMonthList) {
        List<ModelChart> chartData = new ArrayList<>();
        for (YearMonth yearMonth : yearMonthList) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", new Locale("es", "ES"));
            String monthName = yearMonth.format(formatter);
            monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1);
            double[] monthData = dataMap.getOrDefault(String.valueOf(yearMonth), new double[7]);
            chartData.add(new ModelChart(monthName, monthData));
        }
        return chartData;
    }

    private int getCategoryIndex(String categoryId) {
        for (int i = 0; i < Category.values().length; i++) {
            if (Category.values()[i].getId().equals(categoryId)) {
                return i;
            }
        }
        return -1;
    }
}
