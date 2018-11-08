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
        return toDoEntityPlaceholderClient.getEntity(todoId, "/todos/", ToDoEntity.class);
    }

    public CommentEntity getComment(int commentId){
        return commentEntityPlaceholderClient.getEntity(commentId, "/comments/", CommentEntity.class);
    }

    public UserEntity getUser(int userId) {
        return userEntityPlaceholderClient.getEntity(userId, "/users/", UserEntity.class);
    }

    public <T extends Entity> T getEntityAsync(int id, String endpointSuffix, Class<T> cls) {
        T result = null;
        PlaceholderClient<T> client = getAppropriateDaoClient(cls);

        CompletableFuture<T> task = CompletableFuture.supplyAsync(() -> client.getEntity(id, endpointSuffix, cls));
        try {
            log.info("Async callback starts processing request from {} client...", cls.getName());
            result = task.get();
        }
        catch(ExecutionException | InterruptedException ex)
        {
            log.error(ex.getMessage());
        }
        return result;
    }

    public SummaryEntity getSummaryAsync(int id) {
        ToDoEntity entity = getEntityAsync(id, "/todos/", ToDoEntity.class);

        return SummaryEntity.setExternal(
                entity,
                getEntityAsync(id, "/comments/", CommentEntity.class),
                getEntityAsync(entity.getUserId(), "/users/", UserEntity.class));
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
