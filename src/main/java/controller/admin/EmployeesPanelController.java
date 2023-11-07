package controller.admin;

import model.dao.impl.EmployeeDAOImpl;
import model.entity.Dish;
import model.entity.Employee;
import model.enums.CrudAction;
import view.admin.AdminIntranetFrame;
import view.admin.EmployeesPanel;
import view.components.modal.CustomModal;
import view.components.modal.employees.EmployeeActionController;
import view.listeners.ModalListeners;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeesPanelController extends AdminAbstractController implements ActionListener, ModalListeners {

    private final EmployeesPanel employeesPanel;
    private final EmployeeDAOImpl employeeDAO;
    private Employee selectedEmployee;
    private DefaultTableModel tableModel;
    private List<Employee> cachedEmployees = new ArrayList<>();

    public EmployeesPanelController(AdminIntranetFrame adminIntranetFrm, EmployeesPanel employeesPanel) {
        super(adminIntranetFrm);
        this.employeesPanel = employeesPanel;
        this.employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    public void init() {
        //Listeners
        employeesPanel.btnAdd.addActionListener(this);
        employeesPanel.btnEdit.addActionListener(this);
        employeesPanel.btnDelete.addActionListener(this);

        // Disable buttons
        employeesPanel.btnEdit.setEnabled(false);
        employeesPanel.btnDelete.setEnabled(false);

        // Table header configuration
        tableModel = (DefaultTableModel) employeesPanel.employeesTable.getModel();
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBorder(null);
        renderer.setForeground(new Color(176, 176, 176));
        renderer.setBackground(new Color(21, 22, 26));
        employeesPanel.employeesTable.getTableHeader().setDefaultRenderer(renderer);
        employeesPanel.employeesTable.getTableHeader().setPreferredSize(new Dimension(0, 50));

        // Some methods
        employeesPanel.jScrollPane1.setName("employeesTable");
        loadEmployees();
        tableListener();
    }

    private void loadEmployees() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            cachedEmployees = employeeDAO.findAll();

            employeesPanel.spinnerProgress.setValue(100);
            changePanel(employeesPanel.jScrollPane1);
            tableModel.setRowCount(0);

            cachedEmployees.forEach(employee -> {
                tableModel.addRow(new Object[]{
                        employee.getId(),
                        employee.getNames() + " " + employee.getLastNames(),
                        employee.getRole().getRoleName()
                });
            });


        });

        executorService.shutdown();
    }

    private void changePanel(Component panel){
        CardLayout cardLayout = (CardLayout) employeesPanel.mainPanel.getLayout();
        cardLayout.show(employeesPanel.mainPanel, panel.getName());
    }

    private void tableListener(){
        employeesPanel.employeesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = employeesPanel.employeesTable.rowAtPoint(evt.getPoint());
                int col = employeesPanel.employeesTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    employeesPanel.btnEdit.setEnabled(true);
                    employeesPanel.btnDelete.setEnabled(true);
                    selectedEmployee = getSelectedEmployee(row);
                }
            }
        });
    }

    private Employee getSelectedEmployee(int selectedRow) {
        return cachedEmployees.get(selectedRow);
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        cachedEmployees.forEach(employee -> {
            String roleName = employee.getRole().getRoleName();
            String role = Character.toUpperCase(roleName.charAt(0)) + roleName.substring(1).toLowerCase();
            tableModel.addRow(new Object[]{
                    employee.getId(),
                    employee.getNames() + " " + employee.getLastNames(),
                    role
            });
        });
    }

    private void resetSelection(){
        employeesPanel.employeesTable.clearSelection();
        employeesPanel.btnEdit.setEnabled(false);
        employeesPanel.btnDelete.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == employeesPanel.btnAdd){
            EmployeeActionController employeeActionController = new EmployeeActionController(
                    new CustomModal(),
                    adminIntranetFrm,
                    EmployeesPanelController.this,
                    CrudAction.ADD
            );
            employeeActionController.showModal();
        }
        if(e.getSource() == employeesPanel.btnEdit){
            EmployeeActionController employeeActionController = new EmployeeActionController(
                    new CustomModal(),
                    adminIntranetFrm,
                    EmployeesPanelController.this,
                    CrudAction.EDIT,
                    selectedEmployee
            );
            employeeActionController.showModal();
        }
        if(e.getSource() == employeesPanel.btnDelete){
            EmployeeActionController employeeActionController = new EmployeeActionController(
                    new CustomModal(),
                    adminIntranetFrm,
                    EmployeesPanelController.this,
                    CrudAction.DELETE,
                    selectedEmployee
            );
            employeeActionController.showModal();
        }
    }

    @Override
    public void onEditDishModalClose() {

    }

    @Override
    public void onClientInfoModalClose() {

    }

    @Override
    public void onDishActionModalClose(Dish dish, CrudAction crudAction) {

    }

    @Override
    public void onEmployeeActionModalClose(Employee employee, CrudAction crudAction) {
        switch (crudAction) {
            case ADD -> {
                cachedEmployees.add(employee);
                updateTable();
                resetSelection();
            }
            case EDIT -> {
                cachedEmployees.set(cachedEmployees.indexOf(selectedEmployee), employee);
                updateTable();
                resetSelection();
            }
            case DELETE -> {
                cachedEmployees.remove(selectedEmployee);
                updateTable();
                resetSelection();
            }
        }
    }
}
