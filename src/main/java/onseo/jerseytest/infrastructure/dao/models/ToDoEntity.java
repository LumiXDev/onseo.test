package onseo.jerseytest.infrastructure.dao.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ToDoEntity implements Entity {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public String getEndpointSuffix() {
        return "todos/";
    }
}
