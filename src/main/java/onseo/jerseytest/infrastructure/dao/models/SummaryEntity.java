package onseo.jerseytest.infrastructure.dao.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SummaryEntity {
    private ToDoEntity toDoEntity;
    private CommentEntity commentEntity;
    private UserEntity userEntity;
}
