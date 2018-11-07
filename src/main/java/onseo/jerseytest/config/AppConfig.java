package onseo.jerseytest.config;

import onseo.jerseytest.config.properties.PlaceholderClientProperties;
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
    PlaceholderClient<ToDoEntity> toDoEntityPlaceholderClient(PlaceholderClientProperties props) {
        return new PlaceholderClient<>(props);
    }

    @Bean
    PlaceholderClient<CommentEntity> commentEntityPlaceholderClient(PlaceholderClientProperties props) {
        return new PlaceholderClient<>(props);
    }

    @Bean
    PlaceholderClient<UserEntity> userEntityPlaceholderClient(PlaceholderClientProperties props) {
        return new PlaceholderClient<>(props);
    }

    @Bean
    @Autowired
    SummaryService summaryService(PlaceholderClient<ToDoEntity> tdeClient, PlaceholderClient<CommentEntity> ceClient, PlaceholderClient<UserEntity> uClient) {
        return new SummaryService(tdeClient, ceClient, uClient);
    }

    @Bean
    PlaceholderClientProperties placeholderClientProperties() {
        return new PlaceholderClientProperties();
    }
}