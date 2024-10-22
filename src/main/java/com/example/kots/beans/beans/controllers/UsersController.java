package com.example.kots.beans.beans.controllers;


import com.example.kots.beans.beans.models.User;
import com.example.kots.beans.beans.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users/show";
    }

    @GetMapping("/addUser")
    public String showUserAddPage(Model model) {
        model.addAttribute("user", new User());
        return "/users/addUser";
    }


    @PostMapping("/addNewUser")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/editUserPage")
    public String showUserEditPage(@ModelAttribute("user") User user) {
        return "/users/editUserPage";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute User user) {
        System.out.println(user.getId());
        userService.updateUser(user.getId(),user);
        return "redirect:/users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute User user) {
        userService.deleteUser(user.getId());
        return "redirect:/users";
    }


}
