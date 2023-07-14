package controller.admin;

import net.miginfocom.swing.MigLayout;
import view.admin.AdminIntranetFrame;
import view.admin.DashboardPanel;
import view.components.admin.ButtonMenu;

import java.awt.*;

public class AdminFrameController extends AdminAbstractController{

    public AdminFrameController(AdminIntranetFrame adminIntranetFrm) {
        super(adminIntranetFrm);
    }

    @Override
    public void init() {
        adminIntranetFrm.navBarPanel.setLayout(new MigLayout("wrap, fillx, inset 2", "[fill]", "[]4[]"));

        setMenuOption("Dashboard", 0);
        setMenuOption("Analíticas", 1);
        setMenuOption("Menú (Carta)",2);
        setMenuOption("Cerrar sesión", 3);
    }

    private void setMenuOption(String text, int menu_index){
        ButtonMenu buttonMenu = new ButtonMenu();
        buttonMenu.setText(text);
        adminIntranetFrm.navBarPanel.add(buttonMenu);
        buttonMenu.addActionListener(e -> {
            setMenuOptionSelected(buttonMenu);
            changeMenuOption(menu_index);
        });
    }

    private void setMenuOptionSelected(ButtonMenu buttonMenu){
        for(Component comp : adminIntranetFrm.navBarPanel.getComponents()){
            if(comp instanceof ButtonMenu){
                ((ButtonMenu) comp).setSelected(false);
            }
        }
        buttonMenu.setSelected(true);
    }

    private void changeMenuOption(int menu_index){
        switch (menu_index) {
            case 0 -> showMenuPanel(new DashboardPanel());
            case 1 -> System.out.println("Analíticas");
            case 2 -> System.out.println("Menú (Carta)");
            case 3 -> System.out.println("Cerrar sesión");
        }
    }

    private void showMenuPanel(Component component){
        adminIntranetFrm.mainPanel.removeAll();
        adminIntranetFrm.mainPanel.add(component);
        adminIntranetFrm.mainPanel.revalidate();
        adminIntranetFrm.mainPanel.repaint();
    }
}
