package model.dao;

import model.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getUser(String username);
    List<Employee> findAll();
    void save(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
}
