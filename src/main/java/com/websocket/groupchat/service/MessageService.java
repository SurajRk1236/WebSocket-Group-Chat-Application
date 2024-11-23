package com.websocket.groupchat.service;

import com.websocket.groupchat.entity.Message;
import com.websocket.groupchat.requests.MessageDTO;

import java.util.List;

public interface MessageService {
    List<Message> getMessagesByGroupId(String groupId);

    MessageDTO sendMessage(MessageDTO messageDTO);
}
