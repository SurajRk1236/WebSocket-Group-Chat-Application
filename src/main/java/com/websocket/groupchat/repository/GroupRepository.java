package com.websocket.groupchat.repository;

import com.websocket.groupchat.entity.Group;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends MongoRepository<Group, ObjectId> {

    Group findById(String groupId);
}
