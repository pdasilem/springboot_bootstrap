package ru.pdasilem.spring_bootstrap.dao;

import org.springframework.stereotype.Repository;
import ru.pdasilem.spring_bootstrap.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> findRolesById(Long[] ids) {
        return (Set<Role>) entityManager
                .createQuery("select r from Role r where r.id in (:ids)")
                .setParameter("ids", Arrays.asList(ids))
                .getResultStream()
                .collect(Collectors.toSet());
    }
}
