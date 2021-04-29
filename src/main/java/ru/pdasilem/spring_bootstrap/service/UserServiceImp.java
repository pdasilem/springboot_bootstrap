package ru.pdasilem.spring_bootstrap.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.pdasilem.spring_bootstrap.model.UserModel;
import ru.pdasilem.spring_bootstrap.repository.UserRepo;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService{

    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserModel> usersList() {
        return userRepo.findAll();
    }

    @Override
    public UserModel showById(long id) {
        Optional<UserModel> userModel = userRepo.findById(id);
        return userModel.get();
    }

    @Override
    public void save(UserModel userModel) {
        userModel.setPassw(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        userRepo.save(userModel);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(UserModel newUser, long id) {
        Optional<UserModel> userModelOpt = userRepo.findById(id);
        UserModel userModel = userModelOpt.get();
        userModel.setRoles(newUser.getRoles());
        userModel.setEmail(newUser.getEmail());
        userModel.setAge(newUser.getAge());
        userModel.setName(newUser.getName());
        userModel.setSurName(newUser.getSurName());
        userModel.setUserLogin(newUser.getUserLogin());
        userModel.setPassw(newUser.getPassw());
        userRepo.save(userModel);
    }

    @Override
    public UserModel getUserByLogin(String uLogin) {
        return userRepo.findByUserLogin(uLogin);
    }


}
