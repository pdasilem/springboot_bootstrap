package ru.pdasilem.spring_bootstrap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pdasilem.spring_bootstrap.model.Roles;
import ru.pdasilem.spring_bootstrap.model.UserModel;
import ru.pdasilem.spring_bootstrap.service.RoleService;
import ru.pdasilem.spring_bootstrap.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;


    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.usersList());
        return "users";
    }

    @GetMapping("/newuser")
    public String newUser(Model model) {
        model.addAttribute("user", new UserModel());
        return "newuser";
    }

    @PostMapping("/newuser")
    public String createUser(@ModelAttribute("userModel") UserModel userModel, @RequestParam(value = "roles") Long[] role) {
        Set<Roles> roleSet = new HashSet<>();
        for (Long roles : role) {
            roleSet.add(roleService.findRoleById(roles));
        }
        userModel.setRoles(roleSet);
        userService.save(userModel);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/update")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.showById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("userModel") UserModel userModel, @RequestParam(value = "roles") Long[] role) {
        Set<Roles> roleSet = new HashSet<>();
        for (Long roles : role) {
            roleSet.add(roleService.findRoleById(roles));
        }
        userModel.setRoles(roleSet);
        userService.update(userModel, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }


    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        UserModel user = userService.showById(id);
        model.addAttribute("user", user);
        return "user";
    }

}
