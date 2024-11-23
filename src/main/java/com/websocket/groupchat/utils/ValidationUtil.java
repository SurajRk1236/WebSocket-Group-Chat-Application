package com.websocket.groupchat.utils;


import com.websocket.groupchat.entity.Group;
import com.websocket.groupchat.enums.CommonErrorResponse;
import com.websocket.groupchat.exceptions.GenericException;

public class ValidationUtil {
    ValidationUtil() {
    }

    public static void validateGroupExists(Group group) {
        if (group == null) {
            throw new GenericException(CommonErrorResponse.JWTE002);
        }
    }
}
