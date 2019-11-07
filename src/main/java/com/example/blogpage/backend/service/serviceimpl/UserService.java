package com.example.blogpage.backend.service.serviceimpl;

import com.example.blogpage.backend.ModelGUI.UserGUI;
import com.example.blogpage.backend.model.User;
import com.example.blogpage.backend.repository.UserRepository;
import com.example.blogpage.backend.service.IUserService;
import com.example.blogpage.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserGUI> getAllUSers() {
        List<User> users = userRepository.findAll();
        List<UserGUI> guiUsers = new ArrayList<>();
        for (User user :
                users) {
            guiUsers.add(new UserGUI(user.getId(), user.getUsername()));
        }

        return guiUsers;
    }

    @Override
    public UserGUI getUser(long id) {
        Optional<User> optUser = userRepository.findById(id);

        if (optUser.isPresent()) {
            User user = optUser.get();
            return new UserGUI(user.getId(), user.getUsername());
        } else {
            throw new NotFoundException("user with id: " + id + " is not found!");
        }
    }

    @Override
    public UserGUI createUser(User user) {
        User newUser = userRepository.save(user);
        return new UserGUI(newUser.getId(), newUser.getUsername());
    }

    @Override
    public UserGUI updateUser(long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    User _user = userRepository.save(user);
                    return new UserGUI(_user.getId(), _user.getUsername());
                }).orElseThrow(() -> new NotFoundException("user with id: " + id + " is not found!"));
    }

    @Override
    public String deleteUser(long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return "User deleted successfully!";
                }).orElseThrow(() -> new NotFoundException("user with id: " + id + " is not found!"));
    }
}
