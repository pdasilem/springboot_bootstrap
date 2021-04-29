package ru.pdasilem.spring_bootstrap.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.pdasilem.spring_bootstrap.repository.UserRepo;


@Service
public class UserDetailServiceImp implements UserDetailsService {

    private final UserRepo userRepo;


    public UserDetailServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String uLogin) throws UsernameNotFoundException {
        return userRepo.findByUserLogin(uLogin);
    }
}
