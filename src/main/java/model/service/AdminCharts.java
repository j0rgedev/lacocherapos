package model.service;

import model.dao.impl.OrderDAOImpl;
import model.dto.DashboardDTOS;
import view.components.admin.charts.common.ModelChart;

import java.util.List;

public class AdminCharts {
    private final OrderDAOImpl orderDAO;
    private final LineChartManager lineChartManager;
    private final static int EXPECTED_QUANTITY_TODAY_GOAL = 100; // Change this value to modify the first progress bar
    private final static int EXPECTED_AMOUNT_TODAY_GOAL = 500; // Change this value to modify the second progress bar

    public AdminCharts() {
        this.orderDAO = new OrderDAOImpl();
        this.lineChartManager = new LineChartManager(orderDAO);
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
        return lineChartManager.generateLineChartData();
    }
}




