package ru.pdasilem.spring_bootstrap.service;


import ru.pdasilem.spring_bootstrap.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersWithRoles();
    void save(User user, Long[] roles);
    void delete(Long id);
    User getUserById(Long id);
    void update(Long id, User updUser, Long[] roles);
}

