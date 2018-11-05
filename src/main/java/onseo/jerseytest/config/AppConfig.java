package onseo.jerseytest.config;

import onseo.jerseytest.infrastructure.dao.PlaceholderClient;
import onseo.jerseytest.infrastructure.dao.models.CommentEntity;
import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;
import onseo.jerseytest.infrastructure.dao.models.UserEntity;
import onseo.jerseytest.services.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import org.glassfish.jersey.server.ResourceConfig;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.sql.DataSource;

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

    //Do not forget to inject data source props
    /*@Inject
    DataSourceProperties dataSourceProperties;

    @Named
    static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            this.packages("onseo.jerseytest");
        }
    }

    @Bean
    DataSource dataSource() {
        //Bind project properties here if necessary
        DataSource dataSource = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword())
                .build();
        //Do not forget to call build()
        //Return new DataSource object here
        return new DataSourceSpy(dataSource);
    }*/
}