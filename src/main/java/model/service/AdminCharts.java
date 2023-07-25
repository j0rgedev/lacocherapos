package model.service;

import model.dao.impl.DishDAOImpl;
import model.dao.impl.OrderDAOImpl;
import model.dto.DashboardDTOS;
import view.components.admin.charts.common.ModelChart;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class AdminCharts {
    private final OrderDAOImpl orderDAO;
    private final DishDAOImpl dishDAO;
    private final LineChartManager lineChartManager;
    private final BarChartManager barChartManager;
    private final static int EXPECTED_QUANTITY_TODAY_GOAL = 100; // Change this value to modify the first progress bar
    private final static int EXPECTED_AMOUNT_TODAY_GOAL = 500; // Change this value to modify the second progress bar

    public AdminCharts() {
        this.orderDAO = new OrderDAOImpl();
        this.lineChartManager = new LineChartManager(orderDAO);
        this.barChartManager = new BarChartManager(orderDAO);
        this.dishDAO = new DishDAOImpl();
    }

    public DashboardDTOS.AmountProgress getOrdersTotalAmountForToday() {
        double ordersTotalAmountForToday = orderDAO.getOrdersTotalAmountForToday();
        return new DashboardDTOS.AmountProgress(EXPECTED_AMOUNT_TODAY_GOAL, (int) ordersTotalAmountForToday);
    }

    public DashboardDTOS.QuantityProgress getOrdersPercentageForToday() {
        int ordersQuantityForToday = orderDAO.getOrdersQuantityForToday();
        double percentage = (double) ordersQuantityForToday / EXPECTED_QUANTITY_TODAY_GOAL * 100;
        return new DashboardDTOS.QuantityProgress(EXPECTED_QUANTITY_TODAY_GOAL, (int) percentage);
    }

    public List<ModelChart> getOrdersByMonthAndPaymentMethod() {
        return lineChartManager.generateLineChartData(getCustomLastMonths(6));
    }

    public List<ModelChart> getDishesQuantityByCategory() {
        return barChartManager.generateBarChartData(getCustomLastMonths(3));
    }

    public List<DashboardDTOS.TopFiveDishes> getTopFiveDishes() {
        return dishDAO.getTopFiveDishes();
    }

    public List<DashboardDTOS.TopFiveDishes> getTopFiveDishesByCategory(String categoryId) {
        return dishDAO.getTopFiveDishesByCategory(categoryId);
    }

    public List<DashboardDTOS.TopFiveDishes> getTopFiveDishesByMonth(int month) {
        return dishDAO.getTopFiveDishesByMonth(month);
    }

    private List<YearMonth> getCustomLastMonths(int months) {
        LocalDate currentDate = LocalDate.now();
        List<YearMonth> yearMonthList = new ArrayList<>();
        for (int i = months - 1; i >= 0; i--) {
            YearMonth mes = YearMonth.from(currentDate.minusMonths(i));
            yearMonthList.add(mes);
        }
        return yearMonthList;
    }
}




