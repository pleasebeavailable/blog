package com.example.blogpage.backend.controller;
import com.example.blogpage.backend.ModelGUI.UserGUI;
import com.example.blogpage.backend.model.User;
import com.example.blogpage.backend.service.serviceimpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserGUI> getAllUsers() {
        return userService.getAllUSers();
    }

    @GetMapping("/users/{id}")
    public UserGUI getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public UserGUI createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public UserGUI updateStudent(@PathVariable long id, @Valid @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }
}
