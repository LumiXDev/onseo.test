package onseo.jerseytest.config;

import onseo.jerseytest.infrastructure.dao.PlaceholderClient;
import onseo.jerseytest.infrastructure.dao.models.CommentEntity;
import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;
import onseo.jerseytest.infrastructure.dao.models.UserEntity;
import onseo.jerseytest.services.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    PlaceholderClient<ToDoEntity> toDoEntityPlaceholderClient() {
        return new PlaceholderClient<>();
    }

    @Bean
    PlaceholderClient<CommentEntity> commentEntityPlaceholderClient() {
        return new PlaceholderClient<>();
    }

    @Bean
    PlaceholderClient<UserEntity> userEntityPlaceholderClient() {
        return new PlaceholderClient<>();
    }

    @Bean
    @Autowired
    SummaryService summaryService(PlaceholderClient<ToDoEntity> tdeClient, PlaceholderClient<CommentEntity> ceClient, PlaceholderClient<UserEntity> uClient) {
        return new SummaryService(tdeClient, ceClient, uClient);
    }
}