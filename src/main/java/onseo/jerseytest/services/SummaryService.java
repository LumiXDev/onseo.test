package onseo.jerseytest.services;

import lombok.AllArgsConstructor;
import onseo.jerseytest.infrastructure.dao.PlaceholderClient;
import onseo.jerseytest.infrastructure.dao.models.CommentEntity;
import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;
import onseo.jerseytest.infrastructure.dao.models.UserEntity;

@AllArgsConstructor
public class SummaryService {
    private final PlaceholderClient<ToDoEntity> toDoEntityPlaceholderClient;

    private final PlaceholderClient<CommentEntity> commentEntityPlaceholderClient;

    private final PlaceholderClient<UserEntity> userEntityPlaceholderClient;


    public ToDoEntity getToDo(int todoId) {
        return toDoEntityPlaceholderClient.getEntity(todoId, "/todos/", ToDoEntity.class);
    }

    public CommentEntity getComment(int commentId){
        return commentEntityPlaceholderClient.getEntity(commentId, "/comments/", CommentEntity.class);
    }

    public UserEntity getUser(int userId) {
        return userEntityPlaceholderClient.getEntity(userId, "/users/", UserEntity.class);
    }

    public Object getSummaryObject(int id) {
        //TO BE IMPLEMENTED
        return null;
    }
}
