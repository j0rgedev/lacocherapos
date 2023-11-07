package view.listeners;

import model.entity.Dish;
import model.entity.Employee;
import model.enums.CrudAction;

public interface ModalListeners {
    void onEditDishModalClose();
    void onClientInfoModalClose();
    void onDishActionModalClose(Dish dish, CrudAction crudAction);
    void onEmployeeActionModalClose(Employee employee, CrudAction crudAction);
}
