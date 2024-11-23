package com.websocket.groupchat.service.impl;

import com.websocket.groupchat.entity.User;
import com.websocket.groupchat.repository.UsersRepository;
import com.websocket.groupchat.requests.RegisterRequestDTO;
import com.websocket.groupchat.service.UserService;
import com.websocket.groupchat.utils.EntityToDTOConverter;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public String saveUser(RegisterRequestDTO registerRequestDTO) {
        User user = EntityToDTOConverter.toUserEntity(registerRequestDTO);  // Convert DTO to entity
        user = usersRepository.save(user);
        return user.getId();
    }

    @Override
    public User getUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }
}
