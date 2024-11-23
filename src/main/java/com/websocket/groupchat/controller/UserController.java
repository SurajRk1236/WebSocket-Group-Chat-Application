package com.websocket.groupchat.controller;

import com.websocket.groupchat.requests.RegisterRequestDTO;
import com.websocket.groupchat.responses.CommonResponse;
import com.websocket.groupchat.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public CommonResponse<String> registerUser(@RequestBody RegisterRequestDTO userDTO) {
        String userId = userService.saveUser(userDTO);
        return CommonResponse.<String>builder().data(userId).build();
    }

}
