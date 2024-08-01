package com.JAVASimpleAPI.practice.Controller;

import com.JAVASimpleAPI.practice.Model.User;
import com.JAVASimpleAPI.practice.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/users")
    public String createNewUser(@ModelAttribute User user, Model model) {
        userService.saveNewUser(user);
        model.addAttribute("user", new User());
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String showDeleteForm(Model model) {
        model.addAttribute("user", new User());
        return "delete";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam int id, Model model) {
        userService.deleteUserById(id);
        model.addAttribute("user", new User());
        return "redirect:/delete";
    }

    @GetMapping("/show_users")
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "show_users"; // This should match the Thymeleaf template name
    }
}
