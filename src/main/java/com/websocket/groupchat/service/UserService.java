package com.websocket.groupchat.service;


import com.websocket.groupchat.entity.User;
import com.websocket.groupchat.requests.RegisterRequestDTO;

import java.util.List;

public interface UserService {

    String saveUser(RegisterRequestDTO user);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}
