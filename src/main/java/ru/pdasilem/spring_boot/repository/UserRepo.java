package ru.pdasilem.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pdasilem.spring_boot.model.UserModel;


@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    UserModel findByUserLogin(String userLogin);
}