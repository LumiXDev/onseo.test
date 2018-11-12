package onseo.jerseytest.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import onseo.jerseytest.infrastructure.dao.PlaceholderClient;
import onseo.jerseytest.infrastructure.dao.models.CommentEntity;
import onseo.jerseytest.infrastructure.dao.models.Entity;
import onseo.jerseytest.infrastructure.dao.models.SummaryEntity;
import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;
import onseo.jerseytest.infrastructure.dao.models.UserEntity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@AllArgsConstructor
public class SummaryService {
    private final PlaceholderClient<ToDoEntity> toDoEntityPlaceholderClient;

    private final PlaceholderClient<CommentEntity> commentEntityPlaceholderClient;

    private final PlaceholderClient<UserEntity> userEntityPlaceholderClient;

    public ToDoEntity getToDo(int todoId) {
        return toDoEntityPlaceholderClient.getEntity(todoId, ToDoEntity.class);
    }

    public CommentEntity getComment(int commentId){
        return commentEntityPlaceholderClient.getEntity(commentId, CommentEntity.class);
    }

    public UserEntity getUser(int userId) {
        return userEntityPlaceholderClient.getEntity(userId, UserEntity.class);
    }

    public <T extends Entity> T getEntity(int id, Class<T> cls) {
        PlaceholderClient<T> client = getAppropriateDaoClient(cls);

        return client.getEntity(id, cls);
    }

    public SummaryEntity getSummaryAsync(int id) {
        CompletableFuture<ToDoEntity> toDoFuture = CompletableFuture.supplyAsync(() -> toDoEntityPlaceholderClient.getEntity(id, ToDoEntity.class));
        CompletableFuture<CommentEntity> commentFuture = CompletableFuture.supplyAsync(() -> commentEntityPlaceholderClient.getEntity(id, CommentEntity.class));
        CompletableFuture<UserEntity> userFuture = CompletableFuture.supplyAsync(() -> userEntityPlaceholderClient.getEntity(id, UserEntity.class));

        try {
            return new SummaryEntity(toDoFuture.get(), commentFuture.get(), userFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T extends Entity> PlaceholderClient getAppropriateDaoClient(Class<T> cls)
    {
        if (cls == ToDoEntity.class)
        {
            return toDoEntityPlaceholderClient;
        }
        else if (cls == CommentEntity.class)
        {
            return commentEntityPlaceholderClient;
        }
        else if (cls == UserEntity.class)
        {
            return userEntityPlaceholderClient;
        }
        else
        {
            return null;
        }
    }
}
