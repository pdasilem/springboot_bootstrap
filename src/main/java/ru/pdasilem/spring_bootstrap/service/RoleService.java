package ru.pdasilem.spring_bootstrap.service;

import ru.pdasilem.spring_bootstrap.model.Roles;

import java.util.List;

public interface RoleService  {
    List<Roles> rolesList();
    Roles findRoleById(long id);
}
