package com.websocket.groupchat.service.impl;

import com.websocket.groupchat.entity.Group;
import com.websocket.groupchat.repository.GroupRepository;
import com.websocket.groupchat.requests.GroupDTO;
import com.websocket.groupchat.service.GroupService;
import com.websocket.groupchat.utils.EntityToDTOConverter;
import com.websocket.groupchat.utils.ValidationUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupServiceImpl implements GroupService {

    GroupRepository groupRepository;
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public String createGroup(GroupDTO groupDTO) {
        Group group = EntityToDTOConverter.toGroupEntity(groupDTO);
        group = groupRepository.save(group);
        return group.getId();
    }

    @Override
    public void getGroupById(String groupId) {
        groupRepository.findById(groupId);
    }

    @Override
    public void getAllGroups() {
        groupRepository.findAll();
    }

    @Override
    public void addUserToGroup(String groupId, String userId) {
        Group group = groupRepository.findById(groupId);
        ValidationUtil.validateGroupExists(group);
        group.getUsers().add(userId);
        groupRepository.save(group);
    }
}
