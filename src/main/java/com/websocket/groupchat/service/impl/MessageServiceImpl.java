package com.websocket.groupchat.service.impl;

import com.websocket.groupchat.entity.Group;
import com.websocket.groupchat.entity.Message;
import com.websocket.groupchat.repository.GroupRepository;
import com.websocket.groupchat.repository.MessageRepository;
import com.websocket.groupchat.requests.MessageDTO;
import com.websocket.groupchat.service.MessageService;
import com.websocket.groupchat.utils.EntityToDTOConverter;
import com.websocket.groupchat.utils.ValidationUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageServiceImpl implements MessageService {

    final MessageRepository messageRepository;
    final GroupRepository groupRepository;

    public MessageServiceImpl(MessageRepository messageRepository, GroupRepository groupRepository) {
        this.messageRepository = messageRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Message> getMessagesByGroupId(String groupId) {
        return messageRepository.findByGroupId(groupId);
    }

    @Override
    public MessageDTO sendMessage(MessageDTO messageDTO) {
        Message message = EntityToDTOConverter.toMessageEntity(messageDTO);
        Message savedMessage = messageRepository.save(message);
        //TODO :- Add group to message and user mapping accordingly.
//        if (message.getGroupId() != null) {
//            Group groupOptional = groupRepository.findById(message.getGroupId());
//            ValidationUtil.validateGroupExists(groupOptional);
//            groupOptional.getMessages().add(savedMessage.getId());
//            groupRepository.save(groupOptional);
//        }
        return messageDTO;
    }
}
