package onseo.jerseytest.infrastructure.dao.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SummaryEntity {
    private ToDoEntity toDoEntity;
    private CommentEntity commentEntity;
    private UserEntity userEntity;

    public static SummaryEntity setExternal(ToDoEntity todo, CommentEntity comment, UserEntity user)
    {
        SummaryEntity entity = new SummaryEntity();

        entity.setToDoEntity(todo);
        entity.setCommentEntity(comment);
        entity.setUserEntity(user);

        return entity;
    }
}
