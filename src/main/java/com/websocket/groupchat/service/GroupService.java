package com.websocket.groupchat.service;

import com.websocket.groupchat.requests.GroupDTO;

public interface GroupService {

    String createGroup(GroupDTO group);

    void getGroupById(String groupId);

    void getAllGroups();

    void addUserToGroup(String groupId, String userId);
}
