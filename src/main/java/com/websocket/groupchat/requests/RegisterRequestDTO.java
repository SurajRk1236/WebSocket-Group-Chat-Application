package com.websocket.groupchat.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static com.websocket.groupchat.constants.ErrorMessageConstants.PASSWORD_NOT_NULL;
import static com.websocket.groupchat.constants.ErrorMessageConstants.USER_NAME_NOT_NULL;
import static com.websocket.groupchat.constants.ErrorMessageConstants.VALID_EMAIL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequestDTO {

    @NotNull(message = USER_NAME_NOT_NULL)
    String username;

    @Email(message = VALID_EMAIL)
    String email;

    @NotNull(message = PASSWORD_NOT_NULL)
    String password;
}
