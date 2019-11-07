package com.example.blogpage.backend.service;

import com.example.blogpage.backend.ModelGUI.UserGUI;
import com.example.blogpage.backend.model.User;

import java.util.List;

public interface IUserService {

    List<UserGUI> getAllUSers();

    UserGUI getUser(long id);

    UserGUI createUser(User user);

    UserGUI updateUser(long id, User user);

    String deleteUser(long id);
}
