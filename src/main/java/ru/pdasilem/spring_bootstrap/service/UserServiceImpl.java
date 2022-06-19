package ru.pdasilem.spring_bootstrap.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pdasilem.spring_bootstrap.dao.RoleDAOImpl;
import ru.pdasilem.spring_bootstrap.dao.UserDAOImpl;
import ru.pdasilem.spring_bootstrap.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAOImpl userRepository;
    private final RoleDAOImpl roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDAOImpl userRepository, RoleDAOImpl roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getUsersWithRoles() {
        return userRepository.getUsersWithRoles();
    }

    @Override
    @Transactional
    public void save(User user, Long[] roles) {
        user.setRoles(roleRepository.findRolesById(roles));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    @Transactional
    public void update(Long id, User updUser, Long[] roles) {
        updUser.setRoles(roleRepository.findRolesById(roles));
        if (!userRepository.getUserPassword(id).equals(updUser.getPassword())) {
            updUser.setPassword(passwordEncoder.encode(updUser.getPassword()));
        }
        userRepository.update(id, updUser);
    }
}
