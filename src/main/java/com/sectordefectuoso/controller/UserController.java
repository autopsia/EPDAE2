package com.sectordefectuoso.controller;

import com.sectordefectuoso.model.User;
import com.sectordefectuoso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController implements GenericController<User, String>{
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String getList(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user";
    }

    @PostMapping("/users/save")
    public String save(User user, Model model) {
        userService.create(user);
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/users/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user-add";
    }

    @GetMapping("/users/edit/{id}")
    public String getForUpdate(@PathVariable String id, Model model) {
        User currentObject = userService.findById(id);
        model.addAttribute("user", currentObject);
        return "user-edit";
    }

    @PostMapping("/users/update/{id}")
    public String update(@PathVariable String id, User user, Model model) {
        //Update
        userService.update(user);

        //list
        List<User> objetos = userService.findAll();
        model.addAttribute("users", objetos);
        return "user";
    }

    @GetMapping("/users/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        User aBorrar = userService.findById(id);
        userService.delete(aBorrar);
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user";
    }
}
