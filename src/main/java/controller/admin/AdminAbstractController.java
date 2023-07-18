package controller.admin;

import view.admin.AdminIntranetFrame;

public abstract class AdminAbstractController {

    protected AdminIntranetFrame adminIntranetFrm;


    public AdminAbstractController(AdminIntranetFrame adminIntranetFrm) {
        this.adminIntranetFrm = adminIntranetFrm;
    }

    public AdminAbstractController() {}

    public void init() {}
}
