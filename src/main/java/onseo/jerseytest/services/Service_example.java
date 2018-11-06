/*package onseo.jerseytest.services;

import lombok.AllArgsConstructor;
import onseo.jerseytest.infrastructure.dao.PlaceholderClient;
import onseo.jerseytest.infrastructure.dao.models.CommentEntity;
import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;
import onseo.jerseytest.infrastructure.dao.models.UserEntity;

@AllArgsConstructor
public class Service_example {
    private final PlaceholderClient<ToDoEntity> toDoEntityPlaceholderClient;

    private final PlaceholderClient<CommentEntity> commentEntityPlaceholderClient;

    private final PlaceholderClient<UserEntity> userEntityPlaceholderClient;

    /*To inject necessary data services one should
    modify AppConfig class and add an appropriate bean to
    register a dependency like so:
    @Bean
    Client<TYPE> TYPE_ENTITY_Client() {
        return new Client<>();
    }

    One should also register a service initializer with necessary dependencies
    as follows (Map<String, TYPE_Entity> may also be used in case of multiple dependencies);
    Register a service here:
    @Bean
    @Autowired
    SummaryService summaryService(TYPE_Client<TEntity> client) {
        return new SummaryService(client);
    }

    public ToDoEntity getToDo(int todoId) {
        return toDoEntityPlaceholderClient.getEntity(todoId, "todos/", ToDoEntity.class);
    }

    public CommentEntity getComment(int commentId){
        return commentEntityPlaceholderClient.getEntity(commentId, "comments/", CommentEntity.class);
    }

    public UserEntity getUser(int userId) {
        return userEntityPlaceholderClient.getEntity(userId, "users/", UserEntity.class);
    }

    public Object getSummaryObject(int id) {

        //Not yet implemented
        return null;
    }
}*/
