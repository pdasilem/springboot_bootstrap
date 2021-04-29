package ru.pdasilem.spring_bootstrap.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.pdasilem.spring_bootstrap.model.UserModel;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {

    @Query("select um FROM UserModel um inner JOIN FETCH um.roles where um.userLogin = :uLogin")
    UserModel findByUserLogin(@Param("uLogin") String userLogin);
}