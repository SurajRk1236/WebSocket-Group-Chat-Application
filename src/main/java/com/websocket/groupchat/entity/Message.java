package com.websocket.groupchat.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


import static com.websocket.groupchat.constants.CollectionName.MESSAGE_COLLECTION;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = MESSAGE_COLLECTION)
public class Message {

    String id;

    String sender;

    String receiver;

    String groupId;

    String content;

    @CreatedDate
    LocalDateTime createdAt;

}
