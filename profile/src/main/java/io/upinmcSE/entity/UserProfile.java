package io.upinmcSE.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("user_profile")
public class UserProfile {
    @Id
    String id;

    String userId;
}
