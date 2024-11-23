package com.websocket.groupchat.controller;

import com.websocket.groupchat.requests.GroupDTO;
import com.websocket.groupchat.responses.CommonResponse;
import com.websocket.groupchat.service.GroupService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/groups")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupController {

    final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/create")
    public CommonResponse<String> createGroup(@RequestBody GroupDTO groupDTO) {
        String groupId = groupService.createGroup(groupDTO);
        return CommonResponse.<String>builder().data(groupId).build();
    }

    @PostMapping("/addUser/{groupId}")
    public CommonResponse<String> addUserToGroup(@PathVariable String groupId, @RequestBody String userId) {
        groupService.addUserToGroup(groupId, userId);
        return CommonResponse.<String>builder().data("User added successfully").code("200").build();
    }
}
