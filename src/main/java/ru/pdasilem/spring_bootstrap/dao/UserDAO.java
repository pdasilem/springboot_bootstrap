package ru.pdasilem.spring_bootstrap.dao;




import ru.pdasilem.spring_bootstrap.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsersWithRoles();
    void save(User user);
    void delete(Long id);
    User getUserById(Long id);
    void update(Long id, User updUser);
    String getUserPassword(Long id);
}
