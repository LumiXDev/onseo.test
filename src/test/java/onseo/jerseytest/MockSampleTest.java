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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
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
    public void setup() {
        when(toDoEntityPlaceholderClientMock.getEntity(Matchers.anyInt(), any())).thenReturn(generateToDoStubEntity());
        when(commentEntityPlaceholderClientMock.getEntity(Matchers.anyInt(), any())).thenReturn(generateCommentStubEntity());
        when(userEntityPlaceholderClientMock.getEntity(Matchers.anyInt(), any())).thenReturn(generateUserStubEntity());
        summaryService = new SummaryService(toDoEntityPlaceholderClientMock, commentEntityPlaceholderClientMock, userEntityPlaceholderClientMock);
    }

    @Test
    public void urlToSampleString() {

        System.out.println(summaryService.getToDo(10));
    }

    @Test
    public void urlToSampleGetTodo() {
        ToDoEntity actualToDo = toDoEntityPlaceholderClientMock.getEntity(100, ToDoEntity.class);
        Assert.assertNotNull(actualToDo);

        ToDoEntity expectedToDo = ToDoEntity.builder()
                .id(100)
                .userId(200)
                .title("Some temporary title")
                .completed(true)
                .build();
        checkTodo(expectedToDo, actualToDo);
    }

    private void checkTodo(ToDoEntity expected, ToDoEntity actual) {
        Assert.assertEquals(expected.getUserId(), actual.getUserId());
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getTitle(), actual.getTitle());
        Assert.assertEquals(expected.isCompleted(), actual.isCompleted());
    }

    @Test
    public void urlToSampleGetComment() {
        CommentEntity actualComment = commentEntityPlaceholderClientMock.getEntity(8, CommentEntity.class);
        Assert.assertNotNull(actualComment);

        CommentEntity expectedComment = CommentEntity.builder()
                .id(8)
                .postId(16)
                .name("Some stub comment name")
                .email("someemail@stubdomain.org")
                .body("Some stub comment body.")
                .build();

        checkComment(expectedComment, actualComment);
    }

    private void checkComment(CommentEntity expected, CommentEntity actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPostId(), actual.getPostId());
        Assert.assertEquals(expected.getEmail(), actual.getEmail());
        Assert.assertEquals(expected.getBody(), actual.getBody());
    }

    @Test
    public void urlToSampleGetUser() {
        UserEntity actualUser = userEntityPlaceholderClientMock.getEntity(10, UserEntity.class);
        Assert.assertNotNull(actualUser);

        UserEntity expectedUser = generateUserStubEntity();

        checkUser(expectedUser, actualUser);
    }

    private void checkUser(UserEntity expected, UserEntity actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getWebsite(), actual.getWebsite());
        Assert.assertEquals(expected.getEmail(), actual.getEmail());
        Assert.assertEquals(expected.getPhone(), actual.getPhone());
        Assert.assertEquals(expected.getAddress().getCity(), actual.getAddress().getCity());
        Assert.assertEquals(expected.getAddress().getStreet(), actual.getAddress().getStreet());
        Assert.assertEquals(expected.getAddress().getSuite(), actual.getAddress().getSuite());
        Assert.assertEquals(expected.getAddress().getZipcode(), actual.getAddress().getZipcode());
        Assert.assertEquals(expected.getAddress().getGeo().getLat(), actual.getAddress().getGeo().getLat(), 0);
        Assert.assertEquals(expected.getAddress().getGeo().getLng(), actual.getAddress().getGeo().getLng(), 0);
        Assert.assertEquals(expected.getCompany().getName(), actual.getCompany().getName());
        Assert.assertEquals(expected.getCompany().getBs(), actual.getCompany().getBs());
        Assert.assertEquals(expected.getCompany().getCatchPhrase(), actual.getCompany().getCatchPhrase());
    }

    @Test
    public void urlToSampleGetSummary() {
        System.out.println(summaryService.getSummaryAsync(5));
    }

    private ToDoEntity generateToDoStubEntity() {
        log.info("Generating stub ToDo entity...");
        ToDoEntity result = ToDoEntity.builder()
                .id(100)
                .userId(200)
                .title("Some temporary title")
                .completed(true)
                .build();
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

    private CommentEntity generateCommentStubEntity() {
        log.info("Generating stub Comment entity...");

        CommentEntity result = CommentEntity.builder()
                .id(8)
                .postId(16)
                .name("Some stub comment name")
                .body("Some stub comment body.")
                .email("someemail@stubdomain.org")
                .build();
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

    private UserEntity generateUserStubEntity() {

        log.info("Generating stub User entity...");
        UserEntity res = UserEntity.builder()
                .id(100)
                .name("Some stub name")
                .username("Some stub uSeRnAMe")
                .email("someemail@stub.org")
                .phone("1-800-STUBPHN")
                .website("https://somewebsite.com")
                .address(AddressEntity.builder()
                        .city("New Stubton")
                        .street("Stub ave")
                        .suite("5-star stub")
                        .zipcode("10101010")
                        .geo(GeoEntity.builder()
                                .lat(100)
                                .lng(100)
                                .build())
                .build())
                .company(CompanyEntity.builder()
                        .name("Some stub Inc.")
                        .bs("Some stub BS.")
                        .catchPhrase("Some stub catch phrase!")
                        .build())
                .build();
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
