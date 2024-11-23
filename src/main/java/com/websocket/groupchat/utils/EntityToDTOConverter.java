package com.websocket.groupchat.utils;

import com.websocket.groupchat.entity.Group;
import com.websocket.groupchat.entity.Message;
import com.websocket.groupchat.entity.User;
import com.websocket.groupchat.requests.GroupDTO;
import com.websocket.groupchat.requests.MessageDTO;
import com.websocket.groupchat.requests.RegisterRequestDTO;

public class EntityToDTOConverter {

    EntityToDTOConverter() {

    }

    public static User toUserEntity(RegisterRequestDTO userDTO) {
        return User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .build();
    }

    public static Group toGroupEntity(GroupDTO groupDTO) {
        return Group.builder()
                .groupName(groupDTO.getGroupName())
                .users(groupDTO.getUsers())
                .build();
    }

    public static Message toMessageEntity(MessageDTO messageDTO) {
        return Message.builder()
                .sender(messageDTO.getSender())
                .receiver(messageDTO.getReceiver())
                .groupId(messageDTO.getGroupId())
                .content(messageDTO.getContent())
                .build();
    }
}
