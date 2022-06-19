package ru.pdasilem.spring_bootstrap.dao;


import ru.pdasilem.spring_bootstrap.model.Role;

import java.util.Set;

public interface RoleDAO {
    Set<Role> findRolesById(Long[] ids);
}
