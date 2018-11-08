package onseo.jerseytest;

import onseo.jerseytest.infrastructure.dao.PlaceholderClient;
import onseo.jerseytest.infrastructure.dao.models.CommentEntity;
import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;
import onseo.jerseytest.infrastructure.dao.models.UserEntity;
import onseo.jerseytest.services.SummaryService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

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
    public void setup()
    {
        when(toDoEntityPlaceholderClientMock.getEntity(Matchers.anyInt(), any(), any())).thenReturn(generateStubEntity());
        summaryService = new SummaryService(toDoEntityPlaceholderClientMock, commentEntityPlaceholderClientMock, userEntityPlaceholderClientMock);
    }

    @Test
    public void urlToSampleString() {
        System.out.println(summaryService.getToDo(10));
    }

    @Test
    public void urlToSampleGetSummary() throws InterruptedException {

        System.out.println(summaryService.getEntityAsync(10, "/todos/", ToDoEntity.class));
        Thread.sleep(500);
        System.out.println(summaryService.getEntityAsync(8, "/comments/", CommentEntity.class));
        Thread.sleep(300);
        System.out.println(summaryService.getEntityAsync(5, "/users/", UserEntity.class));
        Thread.sleep(400);
        System.out.println(summaryService.getSummaryAsync(5));
    }

    private ToDoEntity generateStubEntity()
    {
        ToDoEntity result = new ToDoEntity();
        result.setId(100);
        result.setUserId(200);
        result.setTitle("Some temporary title.");
        result.setCompleted(true);

        return result;
    }
}
