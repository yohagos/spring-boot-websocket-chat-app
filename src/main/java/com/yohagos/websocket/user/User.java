package com.yohagos.websocket.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String nickname;
    private String fullname;
    private Status status;
}
