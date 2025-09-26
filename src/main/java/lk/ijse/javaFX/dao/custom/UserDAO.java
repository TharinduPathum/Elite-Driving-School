package lk.ijse.javaFX.dao.custom;

import lk.ijse.orm_coursework.dao.CrudDAO;
import lk.ijse.orm_coursework.entity.User;

public interface UserDAO extends CrudDAO<User> {
    public User getUserByEmail(String email);
}
