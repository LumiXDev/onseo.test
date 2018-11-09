package onseo.jerseytest;

import lombok.extern.slf4j.Slf4j;
import onseo.jerseytest.infrastructure.dao.PlaceholderClient;
import onseo.jerseytest.infrastructure.dao.models.AddressEntity;
import onseo.jerseytest.infrastructure.dao.models.CommentEntity;
import onseo.jerseytest.infrastructure.dao.models.CompanyEntity;
import onseo.jerseytest.infrastructure.dao.models.GeoEntity;
import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;
import onseo.jerseytest.infrastructure.dao.models.UserEntity;
import onseo.jerseytest.services.SummaryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class MockSampleTest {
    //Mocks
    @Mock
    private PlaceholderClient<ToDoEntity> toDoEntityPlaceholderClientMock;
    @Mock
    private PlaceholderClient<CommentEntity> commentEntityPlaceholderClientMock;
    @Mock
    private PlaceholderClient<UserEntity> userEntityPlaceholderClientMock;

    private SummaryService summaryService;

    @Before
    public void setup() throws ExecutionException, InterruptedException {
        CompletableFuture<ToDoEntity> todoTask = CompletableFuture.supplyAsync(this::generateToDoStubEntity);
        CompletableFuture<CommentEntity> commentTask = CompletableFuture.supplyAsync(this::generateCommentStubEntity);
        CompletableFuture<UserEntity> userTask = CompletableFuture.supplyAsync(this::generateUserStubEntity);

        when(toDoEntityPlaceholderClientMock.getEntity(Matchers.anyInt(), any(), any())).thenReturn(todoTask.get());
        when(commentEntityPlaceholderClientMock.getEntity(Matchers.anyInt(), any(), any())).thenReturn(commentTask.get());
        when(userEntityPlaceholderClientMock.getEntity(Matchers.anyInt(), any(), any())).thenReturn(userTask.get());
        summaryService = new SummaryService(toDoEntityPlaceholderClientMock, commentEntityPlaceholderClientMock, userEntityPlaceholderClientMock);
    }

    @Test
    public void urlToSampleString() {
        System.out.println(summaryService.getToDo(10));
    }

    @Test
    public void urlToSampleGetSummary() throws InterruptedException {

        System.out.println(summaryService.getEntityAsync(10, "/todos/", ToDoEntity.class));
        System.out.println(summaryService.getEntityAsync(8, "/comments/", CommentEntity.class));
        System.out.println(summaryService.getEntityAsync(5, "/users/", UserEntity.class));
        System.out.println(summaryService.getSummaryAsync(5));
    }

    private ToDoEntity generateToDoStubEntity()
    {
        log.info("Generating stub ToDo entity...");
        ToDoEntity result = new ToDoEntity();
        result.setId(100);
        result.setUserId(200);
        result.setTitle("Some temporary title.");
        result.setCompleted(true);

        try
        {
            log.info("ToDo thread ({}) goes to sleep", Thread.currentThread().getName());
            Thread.sleep(500);
        }
        catch(InterruptedException ex)
        {
            log.error("ERR: " + ex.getMessage());
        }
        log.info("ToDo thread resumed execution and returned {}", result);
        return result;
    }

    private CommentEntity generateCommentStubEntity()
    {
        log.info("Generating stub Comment entity...");
        CommentEntity result = new CommentEntity();
        result.setId(8);
        result.setPostId(16);
        result.setName("Some stub comment name");
        result.setBody("Some stub comment body.");
        result.setEmail("someemail@stubdomain.org");

        try
        {
            log.info("Comment thread ({}) goes to sleep", Thread.currentThread().getName());
            Thread.sleep(300);
        }
        catch(InterruptedException ex)
        {
            log.error("ERR: " + ex.getMessage());
        }
        log.info("Comment thread resumed execution and returned {}", result);
        return result;
    }

    private UserEntity generateUserStubEntity()
    {
        log.info("Generating stub User entity...");
        UserEntity res = new UserEntity();

        res.setId(100);
        res.setName("Some stub name");
        res.setEmail("someemail@stub.org");
        res.setUsername("Some stub uSeRnAMe");
        res.setWebsite("https://somewebsite.com");
        res.setPhone("1-800-STUBPHN");


        AddressEntity addr = new AddressEntity();
        addr.setCity("New Stubton");
        addr.setStreet("Stub ave");
        addr.setSuite("5-star stub");
        addr.setZipcode("10101010");

        GeoEntity geo = new GeoEntity();
        geo.setLat(100);
        geo.setLng(100);
        addr.setGeo(geo);

        res.setAddress(addr);

        CompanyEntity company = new CompanyEntity();

        company.setName("Some stub Inc.");
        company.setCatchPhrase("Some stub catch phrase!");
        company.setBs("Some stub BS.");

        res.setCompany(company);

        try
        {
            log.info("User thread ({}) goes to sleep", Thread.currentThread().getName());
            Thread.sleep(400);
        }
        catch(InterruptedException ex)
        {
            log.error("ERR: " + ex.getMessage());
        }
        log.info("User thread resumed execution and returned {}", res);
        return res;
    }
}
