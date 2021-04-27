package ru.pdasilem.spring_boot.service;

import ru.pdasilem.spring_boot.model.Roles;
import ru.pdasilem.spring_boot.model.UserModel;


import java.util.List;

public interface UserService {
    List<UserModel> usersList();
    UserModel showById(long id);
    void save(UserModel userModel);
    void delete(long id);
    void update(UserModel newUser, long id);
    UserModel getUserByLogin(String uLogin);

}
