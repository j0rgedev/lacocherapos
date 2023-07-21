package controller.admin;

import net.miginfocom.swing.MigLayout;
import view.admin.AdminIntranetFrame;
import view.admin.DashboardPanel;
import view.admin.MenuPanel;
import view.components.admin.ButtonMenu;

import java.awt.*;

public class AdminFrameController extends AdminAbstractController{

    public AdminFrameController(AdminIntranetFrame adminIntranetFrm) {
        super(adminIntranetFrm);
    }

    @Override
    public void init() {
        // Menu options layout
        adminIntranetFrm.navBarPanel.setLayout(new MigLayout("wrap, fillx, inset 2", "[fill]", "[]4[]"));

        // Menu options
        setMenuOption("Dashboard", 0);
        setMenuOption("Analíticas", 1);
        setMenuOption("Menú (Carta)",2);
        setMenuOption("Cerrar sesión", 3);

        // Default menu option
        setMenuOptionSelected((ButtonMenu) adminIntranetFrm.navBarPanel.getComponent(2));
        changeMenuOption(2);
    }

    // Method to set menu options
    private void setMenuOption(String text, int menu_index){
        ButtonMenu buttonMenu = new ButtonMenu();
        buttonMenu.setText(text);
        adminIntranetFrm.navBarPanel.add(buttonMenu);
        buttonMenu.addActionListener(e -> {
            setMenuOptionSelected(buttonMenu);
            changeMenuOption(menu_index);
        });
    }

    // Method to set selected menu option
    private void setMenuOptionSelected(ButtonMenu buttonMenu){
        for(Component comp : adminIntranetFrm.navBarPanel.getComponents()){
            if(comp instanceof ButtonMenu){
                ((ButtonMenu) comp).setSelected(false);
            }
        }
        buttonMenu.setSelected(true);
    }

    // Method to change menu option
    private void changeMenuOption(int menu_index){
        switch (menu_index) {
            case 0 -> {
                DashboardPanel dashboardPanel = new DashboardPanel();
                showMenuPanel(dashboardPanel, new DashboardPanelController(adminIntranetFrm, dashboardPanel));
            }
            case 1 -> System.out.println("Analíticas");
            case 2 -> {
                MenuPanel menuPanel = new MenuPanel();
                showMenuPanel(menuPanel, new MenuPanelController(adminIntranetFrm, menuPanel));
            }
            case 3 -> System.out.println("Cerrar sesión");
            // Add more cases here
        }
    }

    // Method to show menu panel
    private void showMenuPanel(Component component, AdminAbstractController controller){
        adminIntranetFrm.mainPanel.removeAll();
        adminIntranetFrm.mainPanel.add(component);
        adminIntranetFrm.mainPanel.revalidate();
        adminIntranetFrm.mainPanel.repaint();
        controller.init();
    }
}
