package ru.pdasilem.spring_bootstrap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pdasilem.spring_bootstrap.model.Roles;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Long> {
}
