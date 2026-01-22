package io.upinmcSE.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "follows")
@CompoundIndexes({
        @CompoundIndex(name = "follower_followee_idx", def = "{'followerProfile': 1, 'followeeProfile': 1}", unique = true)
})
public class Follow extends BaseEntity{
    @Id
    private String id;
}
