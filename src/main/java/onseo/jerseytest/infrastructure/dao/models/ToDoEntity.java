package onseo.jerseytest.infrastructure.dao.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Builder;

@Getter
@ToString
@Builder
@Setter
@AllArgsConstructor
public class ToDoEntity implements Entity {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public String getEndpointSuffix() {
        return "/todos/";
    }
}
