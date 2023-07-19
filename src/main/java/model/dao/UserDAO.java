package model.dao;

import model.entity.User;

public interface UserDAO {
    User getUser(String username);
}
