package com.websocket.groupchat.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

import static com.websocket.groupchat.constants.CollectionName.GROUP_COLLECTION;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = GROUP_COLLECTION)
public class Group {

    @MongoId
    String id;

    String groupName;

    List<String> users;

    List<String> messages;

}
