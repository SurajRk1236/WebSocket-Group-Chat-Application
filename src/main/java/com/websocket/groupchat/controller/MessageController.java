package com.websocket.groupchat.controller;

import com.websocket.groupchat.requests.MessageDTO;
import com.websocket.groupchat.responses.CommonResponse;
import com.websocket.groupchat.service.MessageService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/groups")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageController {

    final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/sendMessage/{groupId}")
    @SendTo("/topic/groups/{groupId}")
    public CommonResponse<MessageDTO> handleMessage(@DestinationVariable String groupId, MessageDTO messageDto) {
        messageDto.setGroupId(groupId);
        MessageDTO savedMessage = messageService.sendMessage(messageDto);
        return CommonResponse.<MessageDTO>builder().data(savedMessage).build();
    }
}
