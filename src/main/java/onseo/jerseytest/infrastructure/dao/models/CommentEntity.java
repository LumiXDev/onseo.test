package onseo.jerseytest.infrastructure.dao.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;

@Getter
@Builder
@Setter
@AllArgsConstructor
public class CommentEntity implements Entity{
    private int postId;
    private int id;
    private String name;
    private String body;
    private String email;

    public String getEndpointSuffix()
    {
        return "/comments/";
    }
}
