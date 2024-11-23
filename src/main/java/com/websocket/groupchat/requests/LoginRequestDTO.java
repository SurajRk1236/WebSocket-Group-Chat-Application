package com.websocket.groupchat.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static com.websocket.groupchat.constants.ErrorMessageConstants.PASSWORD_NOT_NULL;
import static com.websocket.groupchat.constants.ErrorMessageConstants.USER_NAME_NOT_NULL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequestDTO {

    @NotNull(message = USER_NAME_NOT_NULL)
    String username;

    @NotNull(message = PASSWORD_NOT_NULL)
    String password;
}
