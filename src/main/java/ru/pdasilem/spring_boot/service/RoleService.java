package ru.pdasilem.spring_boot.service;

import ru.pdasilem.spring_boot.model.Roles;

import java.util.List;

public interface RoleService  {
    List<Roles> rolesList();
    Roles findRoleById(long id);
}
