package ru.pdasilem.spring_bootstrap.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.pdasilem.spring_bootstrap.model.User;

@Controller
public class UserController {

    @GetMapping(value = "/user")
    public String userInfo(ModelMap model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "user";
    }
}
