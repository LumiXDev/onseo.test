package onseo.jerseytest.infrastructure.dao.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
