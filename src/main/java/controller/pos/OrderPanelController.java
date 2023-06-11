package controller.pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import components.pos.DishPanel;
import dao.impl.DishDAOImpl;
import model.Category;
import model.Dish;
import view.pos.OrderPanel;

public class OrderPanelController implements ActionListener {

    private final OrderPanel orderPanel;
    private final DishDAOImpl dishDAO;
    private Map<Category, List<Dish>> productCache = new HashMap<>();

    public OrderPanelController(OrderPanel orderPanel) {
        this.orderPanel = orderPanel;
        dishDAO = new DishDAOImpl();
    }

    public void init() {
        panelConfiguration();
        listeners();
    }

    private void panelConfiguration() {
        // Remove all borders from dishes table
        orderPanel.scrollPaneDishes.setViewportBorder(null);
        orderPanel.scrollPaneDishes.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBorder(null);
        orderPanel.tableDishes.getTableHeader().setDefaultRenderer(renderer);
        orderPanel.tableDishes.getTableHeader().setPreferredSize(new Dimension(0, 0));

        // Align dishes table text
        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(JLabel.LEFT);
        orderPanel.tableDishes.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        orderPanel.tableDishes.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);

        // Products panel layout
        orderPanel.productsPanel.setLayout(new GridLayout(0, 4, 12, 12));
        int ORDER_PANEL_PADDING = 14;
        orderPanel.productsPanel.setBorder(BorderFactory.createEmptyBorder(ORDER_PANEL_PADDING, ORDER_PANEL_PADDING, ORDER_PANEL_PADDING, ORDER_PANEL_PADDING));
    }

    private void listeners() {
        // Buttons
        orderPanel.btnCarta.addActionListener(this);
        orderPanel.btnAntojitos.addActionListener(this);
        orderPanel.btnHotDrinks.addActionListener(this);
        orderPanel.btnColdDrinks.addActionListener(this);
        orderPanel.btnBeer.addActionListener(this);
        orderPanel.btnDrinks.addActionListener(this);
        orderPanel.btnDesserts.addActionListener(this);

        // Mouse listener when user double-clicks on any dish table row
        orderPanel.tableDishes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                    int selectedRow = orderPanel.tableDishes.getSelectedRow();
                    if (selectedRow != -1) {
                        // TODO: Add edit dish modal
                    }
                }
            }
        });
    }

    // Function to handle category buttons
    private void handleCategoryButton(Category category) {
        // Verify if the category dishes are already cached
        if (productCache.containsKey(category)) {
            List<Dish> cachedProducts = productCache.get(category);
            loadProducts(cachedProducts);
        } else {
            // If not, load the dishes from the database
            List<Dish> dishList = dishDAO.getDishesByCategory(category.getId());
            productCache.put(category, dishList);
            loadProducts(dishList);
        }
    }

    private void loadProducts(List<Dish> products) {
        orderPanel.productsPanel.removeAll();
        products.forEach((dish) -> {
            DishPanel dishPanel = new DishPanel();
            dishPanel.lblName.setText(
                    "<html><body><p style='text-align:center; padding: 0 6px;'>" + dish.getName() + "</p></body></html>"
            );
            orderPanel.productsPanel.add(dishPanel);
            orderPanel.productsPanel.revalidate();
            orderPanel.productsPanel.repaint();
            dishPanel.btnAdd.addActionListener((ActionEvent e1) -> {
                System.out.println(dish.getName());
                System.out.println(dishPanel.txtQuantity.getText());
            });
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderPanel.btnCarta) {
            handleCategoryButton(Category.CARTA);
        }
        if (e.getSource() == orderPanel.btnAntojitos) {
            handleCategoryButton(Category.ANTOJITOS);
        }
        if (e.getSource() == orderPanel.btnHotDrinks) {
            handleCategoryButton(Category.BEBIDAS_CALIENTES);
        }
        if (e.getSource() == orderPanel.btnColdDrinks) {
            handleCategoryButton(Category.BEBIDAS_FRIAS);
        }
        if (e.getSource() == orderPanel.btnBeer) {
            handleCategoryButton(Category.CERVEZA);
        }
        if (e.getSource() == orderPanel.btnDrinks) {
            handleCategoryButton(Category.TRAGOS);
        }
        if (e.getSource() == orderPanel.btnDesserts) {
            handleCategoryButton(Category.POSTRES);
        }
    }

}
